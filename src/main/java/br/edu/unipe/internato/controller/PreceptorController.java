package br.edu.unipe.internato.controller;

import br.edu.unipe.internato.model.Preceptor;
import br.edu.unipe.internato.repository.PreceptorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preceptores")
public class PreceptorController {

    private final PreceptorRepository preceptorRepository;

    public PreceptorController(PreceptorRepository preceptorRepository) {
        this.preceptorRepository = preceptorRepository;
    }

    @GetMapping
    public List<Preceptor> listarPreceptores() {
        return preceptorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preceptor> buscarPreceptor(@PathVariable("id") Long id) {
        return preceptorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Preceptor criarPreceptor(@RequestBody Preceptor preceptor) {
        return preceptorRepository.save(preceptor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Preceptor> atualizarPreceptor(@PathVariable("id") Long id,
                                                        @RequestBody Preceptor atualizado) {
        return preceptorRepository.findById(id)
                .map(p -> {
                    if (atualizado.getNome() != null) {
                        p.setNome(atualizado.getNome());
                    }

                    if (atualizado.getEspecialidade() != null) {
                        p.setEspecialidade(atualizado.getEspecialidade());
                    }
                    return ResponseEntity.ok(preceptorRepository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPreceptor(@PathVariable("id") Long id) {
        return preceptorRepository.findById(id)
                .map(p -> {
                    preceptorRepository.delete(p);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
