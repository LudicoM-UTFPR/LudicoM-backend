package com.ludicom.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for LudicoM Backend
 * 
 * This is the entry point for the Spring Boot application that provides
 * REST APIs for the LudicoM system frontend.
 */
@SpringBootApplication
public class LudicomBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LudicomBackendApplication.class, args);
    }
}