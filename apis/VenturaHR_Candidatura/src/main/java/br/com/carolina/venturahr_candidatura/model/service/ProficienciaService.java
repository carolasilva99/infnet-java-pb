package br.com.carolina.venturahr_candidatura.model.service;

import br.com.carolina.venturahr_candidatura.model.domain.Proficiencia;
import br.com.carolina.venturahr_candidatura.model.repository.ProficienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProficienciaService {
    @Autowired
    private ProficienciaRepository proficienciaRepository;


    public void incluirVarios(List<Proficiencia> proficiencias) {
        proficienciaRepository.saveAll(proficiencias);
    }
}
