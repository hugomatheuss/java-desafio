package br.edu.unipe.internato.dto;

import jakarta.validation.constraints.NotBlank;

public class EspecialidadeDTO {

    @NotBlank(message = "Nome da especialidade é obrigatório")
    private String nome;

    public EspecialidadeDTO() {}
    public EspecialidadeDTO(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
