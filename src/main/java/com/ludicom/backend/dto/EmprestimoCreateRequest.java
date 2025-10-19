package com.ludicom.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Data Transfer Object for Emprestimo creation requests.
 */
public class EmprestimoCreateRequest {

    @NotBlank(message = "ID do participante é obrigatório")
    private String idParticipante;

    @NotBlank(message = "ID do evento é obrigatório")
    private String idEvento;

    @NotBlank(message = "Horário do empréstimo é obrigatório")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Horário do empréstimo deve estar no formato HH:MM:SS")
    private String horaEmprestimo;

    @NotBlank(message = "Horário da devolução é obrigatório")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Horário da devolução deve estar no formato HH:MM:SS")
    private String horaDevolucao;

    private Boolean isDevolvido = false;

    // Constructors
    public EmprestimoCreateRequest() {}

    public EmprestimoCreateRequest(String idParticipante, String idEvento, String horaEmprestimo,
                                   String horaDevolucao, Boolean isDevolvido) {
        this.idParticipante = idParticipante;
        this.idEvento = idEvento;
        this.horaEmprestimo = horaEmprestimo;
        this.horaDevolucao = horaDevolucao;
        this.isDevolvido = isDevolvido;
    }

    // Getters and Setters
    public String getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(String idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(String horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public Boolean getIsDevolvido() {
        return isDevolvido;
    }

    public void setIsDevolvido(Boolean isDevolvido) {
        this.isDevolvido = isDevolvido;
    }
}

