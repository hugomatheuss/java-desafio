package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String periodo;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlocacaoAluno> alocacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public List<AlocacaoAluno> getAlocacoes() { return alocacoes; }
    public void setAlocacoes(List<AlocacaoAluno> alocacoes) { this.alocacoes = alocacoes; }
}
