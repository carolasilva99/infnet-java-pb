package br.com.carolina.venturahr_candidatura.model.service;

import br.com.carolina.venturahr_candidatura.model.domain.*;
import br.com.carolina.venturahr_candidatura.model.exception.CandidaturaNaoEncontradaException;
import br.com.carolina.venturahr_candidatura.model.repository.CandidaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CandidaturaService {
    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private ProficienciaService proficienciaService;

    @Autowired
    private CriterioService criterioService;

    public Candidatura incluir(Candidatura candidatura) {
        candidatura.setData(LocalDateTime.now());
        candidatura.setNota(calcularNota(candidatura));

        Candidatura candidaturaSalva = candidaturaRepository.save(candidatura);
        for (Proficiencia proficiencia : candidatura.getProficiencias()) {
            proficiencia.setCandidatura(candidatura);
        }

        proficienciaService.incluirVarios(candidatura.getProficiencias());
        return candidaturaSalva;
    }

    private float calcularNota(Candidatura candidatura) {
        List<Criterio> criteriosVaga = candidatura.getVaga().getCriterios();

        float numerador = 0;
        float somaPesos = 0;

        for (Proficiencia proficiencia : candidatura.getProficiencias()) {
            Criterio criterio = criterioService.buscarPorId(proficiencia.getCriterio().getId());
            float peso = criterio.getPeso();
            float nota = proficiencia.getNota().getValor();
            somaPesos += peso;
            numerador += nota * peso;
        }

        return numerador / somaPesos;
    }

    public List<Candidatura> buscarPorCandidato(int idCandidato) {
        return candidaturaRepository.findAllByCandidato(new Candidato(idCandidato));
    }

    public List<Candidatura> buscarPorVaga(int idVaga) {
        return candidaturaRepository.findAllByVaga(new Vaga(idVaga));
    }

    public Candidatura buscarPorId(int id) {
        return candidaturaRepository
                .findById(id)
                .orElseThrow(() -> new CandidaturaNaoEncontradaException("A candidatura de id " + id + " não foi encontrada!"));
    }
}
