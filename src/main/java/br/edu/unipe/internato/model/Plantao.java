package br.edu.unipe.internato.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "plantoes")
public class Plantao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalTime inicio;
    private LocalTime fim;

    private Long localId;
    private Long especialidadeId;
    private Long preceptorId;

    private int vagas;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getInicio() { return inicio; }
    public void setInicio(LocalTime inicio) { this.inicio = inicio; }

    public LocalTime getFim() { return fim; }
    public void setFim(LocalTime fim) { this.fim = fim; }

    public Long getLocalId() { return localId; }
    public void setLocalId(Long localId) { this.localId = localId; }

    public Long getEspecialidadeId() { return especialidadeId; }
    public void setEspecialidadeId(Long especialidadeId) { this.especialidadeId = especialidadeId; }

    public Long getPreceptorId() { return preceptorId; }
    public void setPreceptorId(Long preceptorId) { this.preceptorId = preceptorId; }

    public int getVagas() { return vagas; }
    public void setVagas(int vagas) { this.vagas = vagas; }
}
