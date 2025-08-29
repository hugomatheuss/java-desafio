package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locais")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String sigla;

    @Column(nullable = false)
    private String endereco;

    private String cep;

    @Column(nullable = false)
    private String cidade;

    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Plantao> plantoes = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public List<Plantao> getPlantoes() { return plantoes; }
    public void setPlantoes(List<Plantao> plantoes) { this.plantoes = plantoes; }
}
