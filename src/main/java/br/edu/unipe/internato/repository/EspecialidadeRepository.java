package br.edu.unipe.internato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unipe.internato.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

}
