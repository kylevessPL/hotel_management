package pl.piasta.hotel.application.helloworld.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String getDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime datetime = LocalDateTime.now();
        return dateFormat.format(datetime);
    }

}
