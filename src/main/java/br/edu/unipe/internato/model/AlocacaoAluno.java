package br.edu.unipe.internato.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alocacoes")
public class AlocacaoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plantao_id", nullable = false)
    private Plantao plantao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Plantao getPlantao() { return plantao; }
    public void setPlantao(Plantao plantao) { this.plantao = plantao; }
}
