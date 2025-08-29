package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plantoes")
public class Plantao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime inicio;

    @Column(nullable = false)
    private LocalTime fim;

    @Column(nullable = false)
    private int vagas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "local_id", nullable = false)
    private Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especialidade_id", nullable = false)
    private Especialidade especialidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preceptor_id")
    private Preceptor preceptor;

    @OneToMany(mappedBy = "plantao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlocacaoAluno> alocacoes = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getInicio() { return inicio; }
    public void setInicio(LocalTime inicio) { this.inicio = inicio; }

    public LocalTime getFim() { return fim; }
    public void setFim(LocalTime fim) { this.fim = fim; }

    public int getVagas() { return vagas; }
    public void setVagas(int vagas) { this.vagas = vagas; }

    public Local getLocal() { return local; }
    public void setLocal(Local local) { this.local = local; }

    public Especialidade getEspecialidade() { return especialidade; }
    public void setEspecialidade(Especialidade especialidade) { this.especialidade = especialidade; }

    public Preceptor getPreceptor() { return preceptor; }
    public void setPreceptor(Preceptor preceptor) { this.preceptor = preceptor; }

    public List<AlocacaoAluno> getAlocacoes() { return alocacoes; }
    public void setAlocacoes(List<AlocacaoAluno> alocacoes) { this.alocacoes = alocacoes; }
}
