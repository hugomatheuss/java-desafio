package br.edu.unipe.internato.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unipe.internato.model.Aluno;
import br.edu.unipe.internato.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}