package br.edu.unipe.internato.controller;

import br.edu.unipe.internato.model.Plantao;
import br.edu.unipe.internato.repository.PlantaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plantoes")
public class PlantaoController {

    private final PlantaoRepository plantaoRepository;

    public PlantaoController(PlantaoRepository plantaoRepository) {
        this.plantaoRepository = plantaoRepository;
    }

    @GetMapping
    public List<Plantao> listar() {
        return plantaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plantao> buscar(@PathVariable("id") Long id) {
        return plantaoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Plantao criar(@RequestBody Plantao p) {
        return plantaoRepository.save(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plantao> atualizar(@PathVariable("id") Long id,
                                             @RequestBody Plantao atualizado) {
        return plantaoRepository.findById(id)
                .map(p -> {
                    if (atualizado.getData() != null) {
                        p.setData(atualizado.getData());
                    }

                    if (atualizado.getInicio() != null) {
                        p.setInicio(atualizado.getInicio());
                    }

                    if (atualizado.getFim() != null) {
                        p.setFim(atualizado.getFim());
                    }

                    if (atualizado.getLocal() != null) {
                        p.setLocal(atualizado.getLocal());
                    }

                    if (atualizado.getEspecialidade() != null) {
                        p.setEspecialidade(atualizado.getEspecialidade());
                    }

                    if (atualizado.getPreceptor() != null) {
                        p.setPreceptor(atualizado.getPreceptor());
                    }

                    if (atualizado.getVagas() > 0) {
                        p.setVagas(atualizado.getVagas());
                    }

                    return ResponseEntity.ok(plantaoRepository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        return plantaoRepository.findById(id)
                .map(p -> {
                    plantaoRepository.delete(p);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
