package br.edu.unipe.internato.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unipe.internato.model.Aluno;
import br.edu.unipe.internato.repository.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
  private final AlunoRepository alunoRepository;

  public AlunoController(AlunoRepository alunoRepository) {
      this.alunoRepository = alunoRepository;
  }

  @GetMapping
  public List<Aluno> listarAlunos() {
      return alunoRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Aluno> buscarAluno(@PathVariable Long id) {
      return alunoRepository.findById(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public Aluno criarAluno(@RequestBody Aluno aluno) {
      return alunoRepository.save(aluno);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
      return alunoRepository.findById(id)
              .map(aluno -> {
                  aluno.setNome(alunoAtualizado.getNome());
                  aluno.setPeriodo(alunoAtualizado.getPeriodo());
                  return ResponseEntity.ok(alunoRepository.save(aluno));
              })
              .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
      return alunoRepository.findById(id)
              .map(aluno -> {
                  alunoRepository.delete(aluno);
                  return ResponseEntity.noContent().<Void>build();
              })
              .orElse(ResponseEntity.notFound().build());
  }
}
