package pl.piasta.hotel.api.additionalservices;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.piasta.hotel.api.TestUtils;
import pl.piasta.hotel.api.additionalservices.mapper.AdditionalServiceMapper;
import pl.piasta.hotel.domain.additionalservices.AdditionalServicesService;
import pl.piasta.hotel.domain.model.additionalservices.AdditionalService;
import pl.piasta.hotel.dto.additionalservices.AdditionalServiceDto;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest(classes = AdditionalServicesServiceController.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class AdditionalServicesServiceControllerTest {

    private static final String ENDPOINT_URL = "/hotel/services/additional-services";

    @InjectMocks
    private AdditionalServicesServiceController additionalServicesServiceController;

    @Mock
    private AdditionalServicesService additionalServicesService;

    @Mock
    private AdditionalServiceMapper additionalServiceMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(additionalServicesServiceController).build();
    }

    @Test
    public void getAllAdditionalServices_Should_Return_Services() throws Exception {
        List<AdditionalService> additionalServices = Arrays.asList(
                new AdditionalService(1, "Service1", new BigDecimal("1.50")),
                new AdditionalService(2, "Service2", new BigDecimal("2.50"))
        );

        List<AdditionalServiceDto> additionalServicesDto = Arrays.asList(
                new AdditionalServiceDto(1, "Service1", new BigDecimal("1.50")),
                new AdditionalServiceDto(2, "Service2", new BigDecimal("2.50"))
        );

        Mockito.when(additionalServiceMapper.mapToDto(ArgumentMatchers.anyList())).thenReturn(additionalServicesDto);
        Mockito.when(additionalServicesService.getAllAdditionalServices()).thenReturn(additionalServices);

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL).contentType(TestUtils.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(TestUtils.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Service1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(new BigDecimal("1.50")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Service2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].price").value(new BigDecimal("2.50")));

        Mockito.verify(additionalServicesService, Mockito.times(1)).getAllAdditionalServices();
        Mockito.verifyNoMoreInteractions(additionalServicesService);
    }

    @Test
    public void getAllAdditionalServices_Should_Return_Empty_List() throws Exception {
        List<AdditionalService> additionalServicesEmptyList = Collections.emptyList();
        List<AdditionalServiceDto> additionalServicesDtoEmptyList = Collections.emptyList();

        Mockito.when(additionalServiceMapper.mapToDto(ArgumentMatchers.anyList())).thenReturn(additionalServicesDtoEmptyList);
        Mockito.when(additionalServicesService.getAllAdditionalServices()).thenReturn(additionalServicesEmptyList);

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL).contentType(TestUtils.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(TestUtils.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.content().string("[]"));

        Mockito.verify(additionalServicesService, Mockito.times(1)).getAllAdditionalServices();
        Mockito.verifyNoMoreInteractions(additionalServicesService);
    }

    @Test
    public void getAllAdditionalServices_Should_Return_Empty_Body() throws Exception {
        Mockito.when(additionalServiceMapper.mapToDto(ArgumentMatchers.anyList())).thenReturn(null);
        Mockito.when(additionalServicesService.getAllAdditionalServices()).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL).contentType(TestUtils.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());

        Mockito.verify(additionalServicesService, Mockito.times(1)).getAllAdditionalServices();
        Mockito.verifyNoMoreInteractions(additionalServicesService);
    }

    @Test
    public void getAllAdditionalServices_Should_Throw_Exception() throws Exception {
        Mockito.when(additionalServiceMapper.mapToDto(ArgumentMatchers.anyList())).thenThrow(new EntityNotFoundException());
        Mockito.when(additionalServicesService.getAllAdditionalServices()).thenThrow(new EntityNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL).contentType(TestUtils.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("exception").value("EntityNotFoundException"));

        Mockito.verify(additionalServicesService, Mockito.times(1)).getAllAdditionalServices();
        Mockito.verifyNoMoreInteractions(additionalServicesService);
    }

}