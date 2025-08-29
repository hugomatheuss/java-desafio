package br.edu.unipe.internato.dto;

public class CoordenadorDTO {
  private String nome;
  private String email;

  public CoordenadorDTO() {}

  public CoordenadorDTO(String nome, String email) {
      this.nome = nome;
      this.email = email;
  }

  // getters e setters
  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
}
