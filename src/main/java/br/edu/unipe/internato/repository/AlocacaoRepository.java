package br.edu.unipe.internato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unipe.internato.model.AlocacaoAluno;

public interface AlocacaoRepository extends JpaRepository<AlocacaoAluno, Long> {
  List<AlocacaoAluno> findByAlunoId(Long alunoId);
  List<AlocacaoAluno> findByPlantaoId(Long plantaoId);
}
