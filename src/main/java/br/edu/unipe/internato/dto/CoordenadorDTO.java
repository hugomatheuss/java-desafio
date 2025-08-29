package br.edu.unipe.internato.dto;

import jakarta.validation.constraints.NotBlank;

public class CoordenadorDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    public CoordenadorDTO() {}

    public CoordenadorDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
