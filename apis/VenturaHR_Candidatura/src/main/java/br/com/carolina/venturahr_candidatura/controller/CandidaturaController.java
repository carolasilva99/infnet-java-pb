package br.com.carolina.venturahr_candidatura.controller;

import br.com.carolina.venturahr_candidatura.model.domain.Candidatura;
import br.com.carolina.venturahr_candidatura.model.exception.CandidaturaNaoEncontradaException;
import br.com.carolina.venturahr_candidatura.model.exception.CriterioNaoEncontradoException;
import br.com.carolina.venturahr_candidatura.model.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/candidaturas")
public class CandidaturaController {
    @Autowired
    private CandidaturaService candidaturaService;

    @PostMapping
    public Candidatura incluir(@Valid @RequestBody Candidatura candidatura) {
        try {
            return candidaturaService.incluir(candidatura);
        }
        catch(CriterioNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/usuarios/{idCandidato}")
    public List<Candidatura> buscarPorCandidato(@PathVariable int idCandidato) {
        try {
            return candidaturaService.buscarPorCandidato(idCandidato);
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/vagas/{idVaga}")
    public List<Candidatura> buscarPorVaga(@PathVariable int idVaga) {
        try {
            return candidaturaService.buscarPorVaga(idVaga);
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Candidatura buscarPorId(@PathVariable int id) {
        try {
            return candidaturaService.buscarPorId(id);
        }
        catch(CandidaturaNaoEncontradaException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
