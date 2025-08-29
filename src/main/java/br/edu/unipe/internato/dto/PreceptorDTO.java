package br.edu.unipe.internato.dto;

import jakarta.validation.constraints.NotBlank;

public class PreceptorDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String especialidade;

    public PreceptorDTO() {}

    public PreceptorDTO(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
}
