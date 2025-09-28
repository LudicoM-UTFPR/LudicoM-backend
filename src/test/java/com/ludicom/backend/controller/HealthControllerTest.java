package com.ludicom.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ludicom.backend.dto.UserCreateRequest;
import com.ludicom.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Unit tests for HealthController
 */
@WebMvcTest(HealthController.class)
@ActiveProfiles("test")
class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void health_ShouldReturnHealthStatus() throws Exception {
        mockMvc.perform(get("/api/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.service").value("LudicoM Backend"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    void info_ShouldReturnApplicationInfo() throws Exception {
        mockMvc.perform(get("/api/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.application").value("LudicoM Backend"))
                .andExpect(jsonPath("$.version").value("1.0.0"));
    }

    @Test
    void welcome_ShouldReturnWelcomeMessage() throws Exception {
        mockMvc.perform(get("/api/welcome"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Welcome to LudicoM Backend API!"));
    }
}