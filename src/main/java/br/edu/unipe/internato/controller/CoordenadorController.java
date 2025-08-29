package br.edu.unipe.internato.controller;

import br.edu.unipe.internato.model.Coordenador;
import br.edu.unipe.internato.repository.CoordenadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordenadores")
public class CoordenadorController {

    private final CoordenadorRepository coordenadorRepository;

    public CoordenadorController(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    @GetMapping
    public List<Coordenador> listarCoordenadores() {
        return coordenadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordenador> buscarCoordenador(@PathVariable("id") Long id) {
        return coordenadorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Coordenador criarCoordenador(@RequestBody Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordenador> atualizarCoordenador(@PathVariable("id") Long id,
                                                            @RequestBody Coordenador atualizado) {
        return coordenadorRepository.findById(id)
                .map(c -> {
                    if (c.getNome() != null) {
                        c.setNome(atualizado.getNome());
                    }

                    if (c.getEmail() != null) {
                        c.setEmail(atualizado.getEmail());
                    }

                    return ResponseEntity.ok(coordenadorRepository.save(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCoordenador(@PathVariable("id") Long id) {
        return coordenadorRepository.findById(id)
                .map(c -> {
                    coordenadorRepository.delete(c);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
