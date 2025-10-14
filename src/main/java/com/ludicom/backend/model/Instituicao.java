package com.ludicom.backend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "instituicao")
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "text")
    private UUID uid;

    @Column(nullable = false, columnDefinition="varchar(200)")
    private String nome;

    private String endereco;

    // Construtores
    public Instituicao() {
    }
    public Instituicao(String nome) {
        this.nome = nome;
    }
    public Instituicao(String nome, String endereco) {
        this(nome);
        this.endereco = endereco;
    }

    // Getters e Setters
    public UUID getUid() {
        return uid;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}