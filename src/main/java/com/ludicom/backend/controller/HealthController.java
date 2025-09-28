package com.ludicom.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Health check and basic API endpoints controller
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HealthController {

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        response.put("service", "LudicoM Backend");
        response.put("version", "1.0.0");
        return ResponseEntity.ok(response);
    }

    /**
     * API info endpoint
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> info() {
        Map<String, Object> response = new HashMap<>();
        response.put("application", "LudicoM Backend");
        response.put("description", "Backend API for LudicoM system");
        response.put("version", "1.0.0");
        response.put("java_version", System.getProperty("java.version"));
        response.put("environment", "development");
        return ResponseEntity.ok(response);
    }

    /**
     * Welcome endpoint
     */
    @GetMapping("/welcome")
    public ResponseEntity<Map<String, String>> welcome() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to LudicoM Backend API!");
        response.put("documentation", "Visit /api/info for more information");
        return ResponseEntity.ok(response);
    }
}