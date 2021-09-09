package br.com.carolina.venturahr_vaga.model.service;

import br.com.carolina.venturahr_vaga.model.domain.Criterio;
import br.com.carolina.venturahr_vaga.model.repository.CriterioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriterioService {
    @Autowired
    private CriterioRepository criterioRepository;

    public void incluirVarios(List<Criterio> criterios) {
       criterioRepository.saveAll(criterios);
    }

}
