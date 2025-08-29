package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coordenadores")
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "coordenador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Semestre> semestres = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Semestre> getSemestres() { return semestres; }
    public void setSemestres(List<Semestre> semestres) { this.semestres = semestres; }
}
