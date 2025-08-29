package br.edu.unipe.internato.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unipe.internato.model.Especialidade;
import br.edu.unipe.internato.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {
    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeService(EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    public List<Especialidade> listarEspecialidades() {
        return especialidadeRepository.findAll();
    }

    public Especialidade salvarEspecialidade(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }
}
