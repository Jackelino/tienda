package edu.escuelait.tienda.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MHelpers {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
