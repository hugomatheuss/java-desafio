package br.edu.unipe.internato.dto;

import jakarta.validation.constraints.NotBlank;

public class AlunoDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Período é obrigatório")
    private String periodo;
    public AlunoDTO() {}

    public AlunoDTO(String nome, String periodo) {
        this.nome = nome;
        this.periodo = periodo;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
}
