package br.edu.unipe.internato.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alocacoes")
public class AlocacaoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alunoId;
    private Long plantaoId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public Long getPlantaoId() { return plantaoId; }
    public void setPlantaoId(Long plantaoId) { this.plantaoId = plantaoId; }
}
