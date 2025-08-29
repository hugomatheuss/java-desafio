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

import br.edu.unipe.internato.model.AlocacaoAluno;
import br.edu.unipe.internato.model.Aluno;
import br.edu.unipe.internato.model.Plantao;
import br.edu.unipe.internato.repository.AlunoRepository;
import br.edu.unipe.internato.repository.PlantaoRepository;
import br.edu.unipe.internato.service.AlocacaoAlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
  private final AlunoRepository alunoRepository;
  private final PlantaoRepository plantaoRepository;
  private final AlocacaoAlunoService alocacaoAlunoService;

  public AlunoController(AlunoRepository alunoRepository,
                           PlantaoRepository plantaoRepository,
                           AlocacaoAlunoService alocacaoAlunoService) {
      this.alunoRepository = alunoRepository;
      this.plantaoRepository = plantaoRepository;
      this.alocacaoAlunoService = alocacaoAlunoService;
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

  @PostMapping("/{alunoId}/alocar/{plantaoId}")
  public ResponseEntity<AlocacaoAluno> alocarPlantao(@PathVariable Long alunoId,
                                                      @PathVariable Long plantaoId) {

      Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
      Plantao plantao = plantaoRepository.findById(plantaoId).orElse(null);

      if (aluno == null || plantao == null) {
          return ResponseEntity.notFound().build();
      }

      long ocupadas = alocacaoAlunoService.listarPorPlantao(plantao.getId()).size();
      if (ocupadas >= plantao.getVagas()) {
          return ResponseEntity.badRequest().body("Plantão cheio. Sem vagas disponíveis.");
      }

      boolean jaAlocado = alocacaoAlunoService.listarPorAluno(aluno.getId())
            .stream()
            .anyMatch(a -> a.getPlantao().getId().equals(plantao.getId()));
      if (jaAlocado) {
          return ResponseEntity.badRequest().body("Aluno já está alocado nesse plantão.");
      }

      boolean sobreposto = alocacaoAlunoService.listarPorAluno(aluno.getId())
            .stream()
            .anyMatch(a -> {
                Plantao p = a.getPlantao();
                return p.getData().equals(plantao.getData()) &&
                        !(plantao.getFim().isBefore(p.getInicio()) || plantao.getInicio().isAfter(p.getFim()));
            });

      if (sobreposto) {
          return ResponseEntity.badRequest().body("Plantão sobreposto com outro já alocado para o aluno.");
      }


      AlocacaoAluno alocacao = new AlocacaoAluno();
      alocacao.setAluno(aluno);
      alocacao.setPlantao(plantao);

      AlocacaoAluno salva = alocacaoAlunoService.salvarAlocacao(alocacao);
      return ResponseEntity.ok(salva);
  }
}
