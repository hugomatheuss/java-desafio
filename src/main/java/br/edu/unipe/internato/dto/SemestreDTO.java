package br.edu.unipe.internato.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class SemestreDTO {

    @NotBlank(message = "Nome do semestre é obrigatório")
    private String nome;

    @NotNull(message = "Data de início é obrigatória")
    private LocalDate inicio;

    @NotNull(message = "Data de fim é obrigatória")
    private LocalDate fim;

    @NotNull(message = "ID do coordenador é obrigatório")
    private Long coordenadorId;

    public SemestreDTO() {}

    public SemestreDTO(String nome, LocalDate inicio, LocalDate fim, Long coordenadorId) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        this.coordenadorId = coordenadorId;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getInicio() { return inicio; }
    public void setInicio(LocalDate inicio) { this.inicio = inicio; }

    public LocalDate getFim() { return fim; }
    public void setFim(LocalDate fim) { this.fim = fim; }

    public Long getCoordenadorId() { return coordenadorId; }
    public void setCoordenadorId(Long coordenadorId) { this.coordenadorId = coordenadorId; }
}
