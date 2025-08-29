package br.edu.unipe.internato.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unipe.internato.model.Plantao;
import br.edu.unipe.internato.repository.PlantaoRepository;

@Service
public class PlantaoService {
    private final PlantaoRepository plantaoRepository;

    public PlantaoService(PlantaoRepository plantaoRepository) {
        this.plantaoRepository = plantaoRepository;
    }

    public List<Plantao> listarPlantoes() {
        return plantaoRepository.findAll();
    }

    public Plantao salvarPlantao(Plantao plantao) {
        return plantaoRepository.save(plantao);
    }

    public List<Plantao> listarPlantoesPorData(LocalDate data) {
        return plantaoRepository.findByData(data);
    }
}
