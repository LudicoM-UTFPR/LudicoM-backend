package com.ludicom.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ludicom.backend.model.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, UUID> {

}
