package com.example.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = {"com.example.demo.model"})
@EnableJpaRepositories(basePackages = {"com.example.demo.repository"})
@ComponentScan(basePackages = {"com.example.demo.controller", "com.example.demo.service"})
public class DatabaseConfig {

}
