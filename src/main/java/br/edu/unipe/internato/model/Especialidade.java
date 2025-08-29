package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidades")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plantao> plantoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Plantao> getPlantoes() { return plantoes; }
    public void setPlantoes(List<Plantao> plantoes) { this.plantoes = plantoes; }
}
