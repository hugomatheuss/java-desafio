package br.edu.unipe.internato.dto;

public class EspecialidadeDTO {

    private String nome;

    public EspecialidadeDTO() {}
    public EspecialidadeDTO(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
