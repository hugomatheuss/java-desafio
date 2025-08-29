package br.edu.unipe.internato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unipe.internato.model.Coordenador;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {

}
