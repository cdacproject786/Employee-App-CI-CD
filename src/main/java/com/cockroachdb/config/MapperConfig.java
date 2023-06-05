package com.cockroachdb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {


    @Bean
    public ModelMapper modelMapper()
    {

        Object object = new Object();
        return new ModelMapper();
    }
}
