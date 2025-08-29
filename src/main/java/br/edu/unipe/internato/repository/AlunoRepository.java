package br.edu.unipe.internato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unipe.internato.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
