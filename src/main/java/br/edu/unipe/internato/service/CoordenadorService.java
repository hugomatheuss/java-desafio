package br.edu.unipe.internato.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unipe.internato.model.Coordenador;
import br.edu.unipe.internato.repository.CoordenadorRepository;

@Service
public class CoordenadorService {
    private final CoordenadorRepository coordenadorRepository;

    public CoordenadorService(CoordenadorRepository coordenadorRepository) {
        this.coordenadorRepository = coordenadorRepository;
    }

    public List<Coordenador> listarCoordenadores() {
        return coordenadorRepository.findAll();
    }

    public Coordenador salvarCoordenador(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }
}
