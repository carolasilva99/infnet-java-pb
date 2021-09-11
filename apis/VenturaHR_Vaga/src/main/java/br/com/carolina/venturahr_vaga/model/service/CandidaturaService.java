package br.com.carolina.venturahr_vaga.model.service;

import br.com.carolina.venturahr_vaga.model.domain.Candidatura;
import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaService {
    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private VagaService vagaService;

    public List<Candidatura> buscarPorVaga(int idVaga) {
        Vaga vaga = vagaService.buscarPorId(idVaga);
        return candidaturaRepository.findAllByVaga(vaga);
    }
}
