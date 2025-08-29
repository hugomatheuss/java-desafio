package br.edu.unipe.internato.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unipe.internato.model.Local;
import br.edu.unipe.internato.repository.LocalRepository;

@Service
public class LocalService {
    private final LocalRepository localRepository;

    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public List<Local> listarLocais() {
        return localRepository.findAll();
    }

    public Local salvarLocal(Local local) {
        return localRepository.save(local);
    }
}
