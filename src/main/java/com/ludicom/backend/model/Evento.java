package com.ludicom.backend.model;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "text")
    private UUID uid;

    @NotBlank(message = "Instituição é obrigatória")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instituicao", nullable = false)
    private Instituicao instituicao;

    @NotBlank(message = "Data do evento é obrigatória")
    @Column(name = "data", nullable = false, columnDefinition="date")
    private LocalDate data;

    @NotBlank(message = "Horário de início é obrigatório")
    @Column(name = "hora_inicio", nullable = false, columnDefinition="time")
    private String horaInicio;

    @NotBlank(message = "Horário de término é obrigatório")
    @Column(name = "hora_fim", nullable = false, columnDefinition="time")
    private String horaFim;

    public UUID getUid() {
        return uid;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public LocalDate getData() {
        return data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}

