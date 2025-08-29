package br.edu.unipe.internato.dto;

import jakarta.validation.constraints.NotNull;

public class AlocacaoDTO {

    @NotNull
    private Long alunoId;

    @NotNull
    private Long plantaoId;

    public AlocacaoDTO() {}

    public AlocacaoDTO(Long alunoId, Long plantaoId) {
        this.alunoId = alunoId;
        this.plantaoId = plantaoId;
    }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public Long getPlantaoId() { return plantaoId; }
    public void setPlantaoId(Long plantaoId) { this.plantaoId = plantaoId; }
}
