package com.ludicom.backend.dto;

/**
 * Data Transfer Object for Emprestimo responses.
 */
public class EmprestimoResponse {

    private String uid;
    private ParticipanteResponse participante;
    private EventoResponse evento;
    private String horaEmprestimo;
    private String horaDevolucao;
    private Boolean isDevolvido;

    // Constructors
    public EmprestimoResponse() {}

    public EmprestimoResponse(String uid, ParticipanteResponse participante, EventoResponse evento,
                              String horaEmprestimo, String horaDevolucao, Boolean isDevolvido) {
        this.uid = uid;
        this.participante = participante;
        this.evento = evento;
        this.horaEmprestimo = horaEmprestimo;
        this.horaDevolucao = horaDevolucao;
        this.isDevolvido = isDevolvido;
    }

    // Getters and Setters
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ParticipanteResponse getParticipante() {
        return participante;
    }

    public void setParticipante(ParticipanteResponse participante) {
        this.participante = participante;
    }

    public EventoResponse getEvento() {
        return evento;
    }

    public void setEvento(EventoResponse evento) {
        this.evento = evento;
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
