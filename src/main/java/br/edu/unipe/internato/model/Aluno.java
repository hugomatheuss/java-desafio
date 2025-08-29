package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String periodo;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlocacaoAluno> alocacoes = new ArrayList<>();

    public Aluno() {}

    public Aluno(String nome, String periodo) {
        this.nome = nome;
        this.periodo = periodo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public List<AlocacaoAluno> getAlocacoes() { return alocacoes; }
    public void setAlocacoes(List<AlocacaoAluno> alocacoes) { this.alocacoes = alocacoes; }

    public void addAlocacao(AlocacaoAluno alocacao) {
        alocacoes.add(alocacao);
        alocacao.setAluno(this);
    }

    public void removeAlocacao(AlocacaoAluno alocacao) {
        alocacoes.remove(alocacao);
        alocacao.setAluno(null);
    }
}
