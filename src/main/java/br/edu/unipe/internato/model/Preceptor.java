package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "preceptores")
public class Preceptor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String especialidade;

    @OneToMany(mappedBy = "preceptor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plantao> plantoes = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public List<Plantao> getPlantoes() { return plantoes; }
    public void setPlantoes(List<Plantao> plantoes) { this.plantoes = plantoes; }
}
