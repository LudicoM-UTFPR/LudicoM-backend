package com.ludicom.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * Data Transfer Object for Evento creation requests.
 */
public class EventoCreateRequest {

    @NotBlank(message = "ID da instituição é obrigatório")
    private String idInstituicao;

    @NotNull(message = "Data do evento é obrigatória")
    private LocalDate data;

    @NotBlank(message = "Horário de início é obrigatório")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Horário de início deve estar no formato HH:MM:SS")
    private String horaInicio;

    @NotBlank(message = "Horário de término é obrigatório")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)$", message = "Horário de término deve estar no formato HH:MM:SS")
    private String horaFim;

    // Constructors
    public EventoCreateRequest() {}

    public EventoCreateRequest(String idInstituicao, LocalDate data, String horaInicio, String horaFim) {
        this.idInstituicao = idInstituicao;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    // Getters and Setters
    public String getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(String idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
}

