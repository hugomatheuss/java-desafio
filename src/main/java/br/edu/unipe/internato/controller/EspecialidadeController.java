package br.edu.unipe.internato.controller;

import br.edu.unipe.internato.model.Especialidade;
import br.edu.unipe.internato.repository.EspecialidadeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeController(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    @GetMapping
    public List<Especialidade> listar() {
        return especialidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> buscar(@PathVariable("id") Long id) {
        return especialidadeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Especialidade criar(@RequestBody Especialidade e) {
        return especialidadeRepository.save(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidade> atualizar(@PathVariable("id") Long id,
                                                   @RequestBody Especialidade atualizado) {
        return especialidadeRepository.findById(id)
                .map(e -> {
                    e.setNome(atualizado.getNome());
                    return ResponseEntity.ok(especialidadeRepository.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        return especialidadeRepository.findById(id)
                .map(e -> {
                    especialidadeRepository.delete(e);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
