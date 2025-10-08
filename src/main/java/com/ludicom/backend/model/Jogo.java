package com.ludicom.backend.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "jogo")
public class Jogo {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "text")
    private UUID uid;

    @NotBlank(message = "Nome do jogo é obrigatório")
    @Column(nullable = false, columnDefinition="varchar(200)")
    private String nome;

    @Column(name = "nome_alternativo", columnDefinition="varchar(200)")
    private String nomeAlternativo;

    @Column(name = "ano_publicacao", columnDefinition="date")
    private LocalDate anoPublicacao;

    @Column(name = "tempo_de_jogo", columnDefinition="int")
    private Integer tempoDeJogo; // em minutos

    @Column(name = "minimo_jogares", columnDefinition="int")
    private Integer minimoJogares;

    @Column(name = "maximo_jogares", columnDefinition="int")
    private Integer maximoJogares;

    @Column(name = "codigo_de_barras")
    private String codigoDeBarras;

    @Column(name = "is_disponivel")
    private Boolean isDisponivel = true;

    @Column(name = "criado_quando", columnDefinition="timestamp")
    private LocalDateTime criadoQuando;

    @Column(name = "atualizado_quando", columnDefinition="timestamp")
    private LocalDateTime atualizadoQuando;

    // Construtores
    public Jogo() {
        this.criadoQuando = LocalDateTime.now();
        this.atualizadoQuando = LocalDateTime.now();
    }

    public Jogo(String nome) {
        this();
        this.nome = nome;
    }

    public Jogo(String nome, String nomeAlternativo, LocalDate anoPublicacao, Integer tempoDeJogo,
                Integer minimoJogares, Integer maximoJogares, String codigoDeBarras, Boolean isDisponivel) {
        this(nome);
        this.nomeAlternativo = nomeAlternativo;
        this.anoPublicacao = anoPublicacao;
        this.tempoDeJogo = tempoDeJogo;
        this.minimoJogares = minimoJogares;
        this.maximoJogares = maximoJogares;
        this.codigoDeBarras = codigoDeBarras;
        this.isDisponivel = isDisponivel;
    }

    // Getters and Setters
    public UUID getUid() {
        return uid;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAlternativo() {
        return nomeAlternativo;
    }
    public void setNomeAlternativo(String nomeAlternativo) {
        this.nomeAlternativo = nomeAlternativo;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getTempoDeJogo() {
        return tempoDeJogo;
    }
    public void setTempoDeJogo(Integer tempoDeJogo) {
        this.tempoDeJogo = tempoDeJogo;
    }

    public Integer getMinimoJogares() {
        return minimoJogares;
    }
    public void setMinimoJogares(Integer minimoJogares) {
        this.minimoJogares = minimoJogares;
    }

    public Integer getMaximoJogares() {
        return maximoJogares;
    }
    public void setMaximoJogares(Integer maximoJogares) {
        this.maximoJogares = maximoJogares;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public Boolean getIsDisponivel() {
        return isDisponivel;
    }
    public void setIsDisponivel(Boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    public LocalDateTime getCriadoQuando() {
        return criadoQuando;
    }
    public void setCriadoQuando(LocalDateTime criadoQuando) {
        this.criadoQuando = criadoQuando;
    }

    public LocalDateTime getAtualizadoQuando() {
        return atualizadoQuando;
    }
    public void setAtualizadoQuando(LocalDateTime atualizadoQuando) {
        this.atualizadoQuando = atualizadoQuando;
    }

}