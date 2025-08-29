package br.edu.unipe.internato.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String periodo;


    public String getNome() {
      return nome;
    }
    public void setNome(String nome) {
      this.nome = nome;
    }

    public String getPeriodo() {
      return periodo;
    }
    public void setPeriodo(String periodo) {
      this.periodo = periodo;
    }
 }
