    package com.ludicom.backend.model;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotBlank;

    /**
     * Entidade Participante para representar os participantes do sistema
     */

    @Entity
    @Table(name = "participante")
    public class Participante {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long uid;

        @Column(unique = true, nullable =true)
        private String id_instituicao;

        @NotBlank(message = "Insira o Nome")
        @Column(unique = false, nullable = false)
        private String nome;

        @Column(unique = true, nullable = false)
        private String email;

        @NotBlank(message = "Insira o documento")
        @Column(unique = true, nullable = false)
        private String documento;

        @Column(unique = true, nullable = true)
        private String ra;

        // Constructors
        public Participante() {
        }

        public Participante(String nome, String email, String id_instituicao, String documento, String ra) {
            this();
            this.nome = nome;
            this.email = email;
            this.id_instituicao = id_instituicao;
            this.documento = documento;
            this.ra = ra;

        }

        public Participante(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

            public Long getId() {
                return uid;
            }

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public String getEmail() { return email; }

            public void setEmail(String email) { this.email = email; }

            public String getId_instituicao() { return id_instituicao; }

            public void setId_instituicao(String id_instituicao) { this.id_instituicao = id_instituicao; }

            public String getDocumento() { return documento; }

            public void setDocumento(String documento) { this.documento = documento; }

            public String getRa() { return ra; }

            public void setRa(String ra) { this.ra = ra; }

        @Override
        public String toString() {
            return "Participante{" +
                    "id=" + uid +
                    ", nome='" + nome + '\'' +
                    ", email='" + email + '\'' +
                    ", id_instituicao='" + id_instituicao + '\'' +
                    ", documento='" + documento + '\'' +
                    ", ra='" + ra + '\'' +
                    '}';
        }
    }