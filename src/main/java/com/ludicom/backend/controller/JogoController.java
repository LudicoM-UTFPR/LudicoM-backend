package com.ludicom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import com.ludicom.backend.service.JogoService;
import com.ludicom.backend.dto.JogoCreateRequest;
import com.ludicom.backend.dto.JogoResponse;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jogos")
@CrossOrigin(origins = "*")
@Validated
public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    /**
     * Criar um novo jogo
     */
    @PostMapping
    public ResponseEntity<JogoResponse> createJogo(@Valid @RequestBody JogoCreateRequest request) {
        try {
            JogoResponse response = jogoService.createJogo(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Listar todos os jogos
     */
    @GetMapping
    public ResponseEntity<List<JogoResponse>> getAllJogos() {
        List<JogoResponse> jogos = jogoService.getAllJogos();
        return ResponseEntity.ok(jogos);
    }
}