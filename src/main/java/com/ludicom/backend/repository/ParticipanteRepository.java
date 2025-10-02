package com.ludicom.backend.repository;

import com.ludicom.backend.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Participante entity
 * Provides database operations for Participante management
 */
@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    /**
     * Find participante by nome
     */
    Optional<Participante> findByNome(String nome);

    /**
     * Find participante by email
     */
    Optional<Participante> findByEmail(String email);

    /**
     * Find all active participantes
     */
    List<Participante> findByIsActiveTrue();

    /**
     * Check if nome exists
     */
    boolean existsByNome(String nome);

    /**
     * Check if email exists
     */
    boolean existsByEmail(String email);

    /**
     * Find participantes by nome containing (case insensitive)
     */
    @Query("SELECT p FROM Participante p WHERE LOWER(p.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Participante> findByNomeContainingIgnoreCase(String nome);
}