package br.edu.unipe.internato.controller;

import br.edu.unipe.internato.model.Local;
import br.edu.unipe.internato.repository.LocalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locais")
public class LocalController {

    private final LocalRepository localRepository;

    public LocalController(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @GetMapping
    public List<Local> listar() {
        return localRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> buscar(@PathVariable("id") Long id) {
        return localRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Local criar(@RequestBody Local l) {
        return localRepository.save(l);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> atualizar(@PathVariable("id") Long id,
                                           @RequestBody Local atualizado) {
        return localRepository.findById(id)
                .map(l -> {
                    if (atualizado.getNome() != null) {
                        l.setNome(atualizado.getNome());
                    }

                    if (atualizado.getSigla() != null) {
                        l.setSigla(atualizado.getSigla());
                    }

                    if (atualizado.getEndereco() != null) {
                        l.setEndereco(atualizado.getEndereco());
                    }

                    if (atualizado.getCidade() != null) {
                        l.setCidade(atualizado.getCidade());
                    }

                    if (atualizado.getCep() != null) {
                        l.setCep(atualizado.getCep());
                    }

                    if (atualizado.getLatitude() != null) {
                        l.setLatitude(atualizado.getLatitude());
                    }

                    if (atualizado.getLongitude() != null) {
                        l.setLongitude(atualizado.getLongitude());
                    }
                    return ResponseEntity.ok(localRepository.save(l));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        return localRepository.findById(id)
                .map(l -> {
                    localRepository.delete(l);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
