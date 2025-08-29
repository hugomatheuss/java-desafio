package br.edu.unipe.internato.dto;

public class AlunoDTO {

    private String nome;
    private String periodo; // P9, P10, etc.

    public AlunoDTO() {}

    public AlunoDTO(String nome, String periodo) {
        this.nome = nome;
        this.periodo = periodo;
    }

    // getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
}
