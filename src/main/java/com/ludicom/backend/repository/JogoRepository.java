package com.ludicom.backend.repository;

import java.util.List;
import java.util.Optional;
import com.ludicom.backend.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    
    Optional<Jogo> findByName(String name);
    
    boolean existsByNome(String nome);

    @Query("SELECT j FROM Jogo j WHERE LOWER(j.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Jogo> findByNomeContainingIgnoreCase(String nome);
}