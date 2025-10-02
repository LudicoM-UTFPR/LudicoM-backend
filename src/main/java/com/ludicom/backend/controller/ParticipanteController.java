package com.ludicom.backend.controller;

import com.ludicom.backend.dto.UserCreateRequest;
import com.ludicom.backend.dto.UserResponse;
import com.ludicom.backend.service.ParticipanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * REST Controller for Participante management
 * Provides endpoints for participante CRUD operations
 */
@RestController
@RequestMapping("/api/participantes")
@CrossOrigin(origins = "*")
public class ParticipanteController {

    private final ParticipanteService participanteService;

    @Autowired
    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    /**
     * Create a new participante
     */
    @PostMapping
    public ResponseEntity<?> createParticipante(@Valid @RequestBody UserCreateRequest request) {
        try {
            UserResponse participante = participanteService.createParticipante(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(participante);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    /**
     * Get all participantes
     */
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllParticipantes() {
        List<UserResponse> participantes = participanteService.getAllParticipantes();
        return ResponseEntity.ok(participantes);
    }

    /**
     * Get all active participantes
     */
    @GetMapping("/active")
    public ResponseEntity<List<UserResponse>> getAllActiveParticipantes() {
        List<UserResponse> participantes = participanteService.getAllActiveParticipantes();
        return ResponseEntity.ok(participantes);
    }

    /**
     * Get participante by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getParticipanteById(@PathVariable Long id) {
        Optional<UserResponse> participante = participanteService.getParticipanteById(id);
        if (participante.isPresent()) {
            return ResponseEntity.ok(participante.get());
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Participante not found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    /**
     * Get participante by nome
     */
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> getParticipanteByNome(@PathVariable String nome) {
        Optional<UserResponse> participante = participanteService.getParticipanteByNome(nome);
        if (participante.isPresent()) {
            return ResponseEntity.ok(participante.get());
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Participante not found with nome: " + nome);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    /**
     * Search participantes by nome
     */
    @GetMapping("/search")
    public ResponseEntity<List<UserResponse>> searchParticipantes(@RequestParam String nome) {
        List<UserResponse> participantes = participanteService.searchParticipantesByNome(nome);
        return ResponseEntity.ok(participantes);
    }

    /**
     * Deactivate participante (soft delete)
     */
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivateParticipante(@PathVariable Long id) {
        boolean success = participanteService.deactivateParticipante(id);
        if (success) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Participante deactivated successfully");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Participante not found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }
}