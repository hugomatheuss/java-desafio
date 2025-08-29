package br.edu.unipe.internato.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unipe.internato.model.AlocacaoAluno;
import br.edu.unipe.internato.repository.AlocacaoRepository;

@Service
public class AlocacaoAlunoService {
    private final AlocacaoRepository alocacaoRepository;

    public AlocacaoAlunoService(AlocacaoRepository alocacaoRepository) {
        this.alocacaoRepository = alocacaoRepository;
    }

    public List<AlocacaoAluno> listarAlocacoes() {
        return alocacaoRepository.findAll();
    }

    public AlocacaoAluno salvarAlocacao(AlocacaoAluno alocacao) {
        return alocacaoRepository.save(alocacao);
    }

    public List<AlocacaoAluno> listarPorAluno(Long alunoId) {
        return alocacaoRepository.findByAlunoId(alunoId);
    }

    public List<AlocacaoAluno> listarPorPlantao(Long plantaoId) {
        return alocacaoRepository.findByPlantaoId(plantaoId);
    }
}
