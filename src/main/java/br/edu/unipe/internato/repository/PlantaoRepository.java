package br.edu.unipe.internato.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unipe.internato.model.Plantao;

public interface PlantaoRepository extends JpaRepository<Plantao, Long> {
  List<Plantao> findByData(LocalDate data);
}
