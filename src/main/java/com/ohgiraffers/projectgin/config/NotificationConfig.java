package com.ohgiraffers.projectgin.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}