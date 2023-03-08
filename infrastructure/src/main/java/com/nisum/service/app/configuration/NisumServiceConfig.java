package com.nisum.service.app.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NisumServiceConfig {

    @Bean
    public ModelMapper modelMapperWithoutStrict() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

}
