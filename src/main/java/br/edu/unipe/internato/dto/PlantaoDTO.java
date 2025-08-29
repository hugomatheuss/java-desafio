package br.edu.unipe.internato.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class PlantaoDTO {

    private LocalDate data;
    private LocalTime inicio;
    private LocalTime fim;
    private Long localId;
    private Long especialidadeId;

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
}
