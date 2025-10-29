package com.ludicom.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludicom.backend.dto.MessageResponse;
import com.ludicom.backend.dto.ParticipanteCreateRequest;
import com.ludicom.backend.dto.ParticipanteResponse;
import com.ludicom.backend.exception.RequiredFieldException;
import com.ludicom.backend.exception.ResourceAlreadyExistsException;
import com.ludicom.backend.exception.ResourceNotFoundException;
import com.ludicom.backend.model.Instituicao;
import com.ludicom.backend.model.Participante;
import com.ludicom.backend.repository.InstituicaoRepository;
import com.ludicom.backend.repository.ParticipanteRepository;

@Service
@Transactional
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;
    private final InstituicaoRepository instituicaoRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository, InstituicaoRepository instituicaoRepository) {
        this.participanteRepository = participanteRepository;
        this.instituicaoRepository = instituicaoRepository;
    }

    /**
     * Criar um novo participante
     */
    public ParticipanteResponse createParticipante(ParticipanteCreateRequest request) {
        if (request.getNome() == null || request.getNome().trim().isEmpty()) {
            throw new RequiredFieldException("Participante", "nome");
        }

        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new RequiredFieldException("Participante", "email");
        }

        if (request.getDocumento() == null || request.getDocumento().trim().isEmpty()) {
            throw new RequiredFieldException("Participante", "documento");
        }

        // Verifica se o email já existe
        if (participanteRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Participante", "email", request.getEmail());
        }

        // Verifica se o documento já existe
        if (participanteRepository.existsByDocumento(request.getDocumento())) {
            throw new ResourceAlreadyExistsException("Participante", "documento", request.getDocumento());
        }

        // Verifica se o RA já existe (se foi fornecido)
        if (request.getRa() != null && !request.getRa().trim().isEmpty() &&
            participanteRepository.existsByRa(request.getRa())) {
            throw new ResourceAlreadyExistsException("Participante", "ra", request.getRa());
        }

        // Valida e busca a instituição se foi fornecida
        Instituicao instituicao = null;
        if (request.getIdInstituicao() != null && !request.getIdInstituicao().trim().isEmpty()) {
            instituicao = instituicaoRepository.findById(request.getIdInstituicao())
                    .orElseThrow(() -> new ResourceNotFoundException("Instituição", "ID", request.getIdInstituicao()));
        }

        if(request.getIdInstituicao().trim().isEmpty()){
            request.setIdInstituicao(null);
        }

        Participante participante = new Participante(
            request.getNome(),
            request.getEmail(),
            request.getIdInstituicao(),
            request.getDocumento(),
            request.getRa()
        );

        Participante savedParticipante = participanteRepository.save(participante);
        return convertToResponse(savedParticipante, instituicao);
    }

    /**
     * Listar todos os participantes
     */
    @Transactional(readOnly = true)
    public List<ParticipanteResponse> getAllParticipantes() {
        return participanteRepository.findAll().stream()
                .map(p -> {
                    Instituicao instituicao = null;
                    if (p.getInstituicao() != null && !p.getInstituicao().isEmpty()) {
                        instituicao = instituicaoRepository.findById(p.getInstituicao()).orElse(null);
                    }
                    return convertToResponse(p, instituicao);
                })
                .collect(Collectors.toList());
    }

    /**
     * Buscar participante por ID (UID)
     */
    @Transactional(readOnly = true)
    public ParticipanteResponse getParticipanteById(String id) {
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participante", "ID", id));

        Instituicao instituicao = null;
        if (participante.getInstituicao() != null && !participante.getInstituicao().isEmpty()) {
            instituicao = instituicaoRepository.findById(participante.getInstituicao()).orElse(null);
        }

        return convertToResponse(participante, instituicao);
    }

    /**
     * Atualizar um participante existente
     */
    public ParticipanteResponse updateParticipante(String id, ParticipanteCreateRequest request) {
        if (request.getNome() == null || request.getNome().trim().isEmpty()) {
            throw new RequiredFieldException("Participante", "nome");
        }

        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new RequiredFieldException("Participante", "email");
        }

        if (request.getDocumento() == null || request.getDocumento().trim().isEmpty()) {
            throw new RequiredFieldException("Participante", "documento");
        }

        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participante", "ID", id));

        // Verifica se o email está sendo alterado e se já existe outro participante com esse email
        if (!participante.getEmail().equals(request.getEmail()) &&
            participanteRepository.existsByEmail(request.getEmail())) {
            throw new ResourceAlreadyExistsException("Participante", "email", request.getEmail());
        }

        // Verifica se o documento está sendo alterado e se já existe outro participante com esse documento
        if (!participante.getDocumento().equals(request.getDocumento()) &&
            participanteRepository.existsByDocumento(request.getDocumento())) {
            throw new ResourceAlreadyExistsException("Participante", "documento", request.getDocumento());
        }

        // Verifica se o RA está sendo alterado e se já existe outro participante com esse RA
        if (request.getRa() != null && !request.getRa().trim().isEmpty()) {
            if (!participante.getRa().equals(request.getRa()) &&
                participanteRepository.existsByRa(request.getRa())) {
                throw new ResourceAlreadyExistsException("Participante", "ra", request.getRa());
            }
        }

        // Valida e busca a instituição se foi fornecida
        Instituicao instituicao = null;
        if (request.getIdInstituicao() != null && !request.getIdInstituicao().trim().isEmpty()) {
            instituicao = instituicaoRepository.findById(request.getIdInstituicao())
                    .orElseThrow(() -> new ResourceNotFoundException("Instituição", "ID", request.getIdInstituicao()));
        }

        if(request.getIdInstituicao().trim().isEmpty()){
            request.setIdInstituicao(null);
        }

        participante.setNome(request.getNome());
        participante.setEmail(request.getEmail());
        participante.setDocumento(request.getDocumento());
        participante.setIdInstituicao(request.getIdInstituicao());
        participante.setRa(request.getRa());

        Participante updatedParticipante = participanteRepository.save(participante);
        return convertToResponse(updatedParticipante, instituicao);
    }

    /**
     * Deletar um participante
     */
    public MessageResponse deleteParticipante(String id) {
        if (!participanteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Participante", "ID", id);
        }
        participanteRepository.deleteById(id);
        return new MessageResponse("Participante deletado com sucesso");
    }

    /**
     * Converter Participante para ParticipanteResponse
     */
    private ParticipanteResponse convertToResponse(Participante participante, Instituicao instituicao) {
        return new ParticipanteResponse(
            participante.getId(),
            participante.getNome(),
            participante.getEmail(),
            participante.getDocumento(),
            instituicao,
            participante.getRa()
        );
    }
}
