package br.edu.unipe.internato.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unipe.internato.model.Preceptor;
import br.edu.unipe.internato.repository.PreceptorRepository;

@Service
public class PreceptorService {
    private final PreceptorRepository preceptorRepository;

    public PreceptorService(PreceptorRepository preceptorRepository) {
        this.preceptorRepository = preceptorRepository;
    }

    public List<Preceptor> listarPreceptores() {
        return preceptorRepository.findAll();
    }

    public Preceptor salvarPreceptor(Preceptor preceptor) {
        return preceptorRepository.save(preceptor);
    }
}
