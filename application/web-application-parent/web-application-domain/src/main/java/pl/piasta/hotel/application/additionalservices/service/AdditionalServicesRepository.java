package pl.piasta.hotel.application.additionalservices.service;

import pl.piasta.hotel.domain.additionalservices.AdditionalService;

import java.util.List;

public interface AdditionalServicesRepository {
    List<AdditionalService> getAllAdditionalServices();
}
