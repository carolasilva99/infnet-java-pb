package br.com.carolina.venturahr_candidatura.model.service;

import br.com.carolina.venturahr_candidatura.model.domain.Criterio;
import br.com.carolina.venturahr_candidatura.model.exception.CriterioNaoEncontradoException;
import br.com.carolina.venturahr_candidatura.model.repository.CriterioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriterioService {
    @Autowired
    private CriterioRepository criterioRepository;


    public Criterio buscarPorId(int id) {
        return criterioRepository
                .findById(id)
                .orElseThrow(() -> new CriterioNaoEncontradoException("O critério de id " + id + " não foi encontrado"));
    }
}
