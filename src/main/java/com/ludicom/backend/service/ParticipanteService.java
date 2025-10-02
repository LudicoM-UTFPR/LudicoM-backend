package com.ludicom.backend.service;

import com.ludicom.backend.dto.UserCreateRequest;
import com.ludicom.backend.dto.UserResponse;
import com.ludicom.backend.model.Participante;
import com.ludicom.backend.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service layer for Participante management
 * Contains business logic for participante operations
 */
@Service
@Transactional
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    @Autowired
    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    /**
     * Create a new participante
     */
    public UserResponse createParticipante(UserCreateRequest request) {
        // Check if nome already exists
        if (participanteRepository.existsByNome(request.getNome())) {
            throw new RuntimeException("Nome already exists: " + request.getNome());
        }

        // Check if email already exists
        if (participanteRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists: " + request.getEmail());
        }

        Participante participante = new Participante(request.getNome(), request.getEmail());
        Participante savedParticipante = participanteRepository.save(participante);
        return convertToResponse(savedParticipante);
    }

    /**
     * Get all participantes
     */
    @Transactional(readOnly = true)
    public List<UserResponse> getAllParticipantes() {
        return participanteRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Get all active participantes
     */
    @Transactional(readOnly = true)
    public List<UserResponse> getAllActiveParticipantes() {
        return participanteRepository.findByIsActiveTrue().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Get participante by ID
     */
    @Transactional(readOnly = true)
    public Optional<UserResponse> getParticipanteById(Long id) {
        return participanteRepository.findById(id)
                .map(this::convertToResponse);
    }

    /**
     * Get participante by nome
     */
    @Transactional(readOnly = true)
    public Optional<UserResponse> getParticipanteByNome(String nome) {
        return participanteRepository.findByNome(nome)
                .map(this::convertToResponse);
    }

    /**
     * Search participantes by nome (contains)
     */
    @Transactional(readOnly = true)
    public List<UserResponse> searchParticipantesByNome(String nome) {
        return participanteRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Deactivate participante (soft delete)
     */
    public boolean deactivateParticipante(Long id) {
        Optional<Participante> participanteOptional = participanteRepository.findById(id);
        if (participanteOptional.isPresent()) {
            Participante participante = participanteOptional.get();
            participante.setIsActive(false);
            participanteRepository.save(participante);
            return true;
        }
        return false;
    }

    /**
     * Convert Participante entity to UserResponse DTO
     */
    private UserResponse convertToResponse(Participante participante) {
        return new UserResponse(
                participante.getId(),
                participante.getNome(),
                participante.getEmail(),
                participante.getCreatedAt(),
                participante.getUpdatedAt(),
                participante.getIsActive()
        );
    }
}