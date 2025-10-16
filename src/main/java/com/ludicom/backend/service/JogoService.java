package com.ludicom.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ludicom.backend.model.Jogo;
import com.ludicom.backend.repository.JogoRepository;
import com.ludicom.backend.dto.JogoCreateRequest;
import com.ludicom.backend.dto.JogoResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class JogoService {

    private final JogoRepository jogoRepository;

    @Autowired
    public JogoService(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    /*
     * Criando um novo jogo
     */
    public JogoResponse createJogo(JogoCreateRequest request) {
        // Verifica se o nome do jogo já existe
        if (jogoRepository.existsByNome(request.getNome())) {
            throw new RuntimeException("Nome do jogo já existe: " + request.getNome());
        }

        Jogo jogo = new Jogo(request.getNome(), request.getNomeAlternativo(), request.getAnoPublicacao(),
                             request.getTempoDeJogo(), request.getMinimoJogadores(), request.getMaximoJogadores(),
                             request.getCodigoDeBarras(), request.getIsDisponivel());
        Jogo savedJogo = jogoRepository.save(jogo);
        return convertToResponse(savedJogo);
    }

    @Transactional(readOnly = true)
    public List<JogoResponse> getAllJogos() {
        return jogoRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private JogoResponse convertToResponse(Jogo jogo) {
        return new JogoResponse(
            jogo.getUid().toString(),
            jogo.getNome(),
            jogo.getNomeAlternativo(),
            jogo.getAnoPublicacao() != null ? jogo.getAnoPublicacao().toString() : null,
            jogo.getTempoDeJogo(),
            jogo.getMinimoJogadores(),
            jogo.getMaximoJogadores(),
            jogo.getCodigoDeBarras(),
            jogo.getIsDisponivel(),
            jogo.getCriadoQuando(),
            jogo.getAtualizadoQuando()
        );
    }
}