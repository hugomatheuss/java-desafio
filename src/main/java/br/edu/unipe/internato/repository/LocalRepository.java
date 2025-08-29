package br.edu.unipe.internato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unipe.internato.model.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {

}
