package br.edu.unipe.internato.dto;

import jakarta.validation.constraints.NotBlank;

public class LocalDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "Cidade é obrigatória")
    private String cidade;

    public LocalDTO() {}

    public LocalDTO(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}
