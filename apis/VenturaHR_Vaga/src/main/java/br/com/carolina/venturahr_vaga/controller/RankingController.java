package br.com.carolina.venturahr_vaga.controller;

import br.com.carolina.venturahr_vaga.model.domain.Ranking;
import br.com.carolina.venturahr_vaga.model.exception.RankingNaoEncontradoException;
import br.com.carolina.venturahr_vaga.model.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/rankings")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @GetMapping("/{id}")
    public Ranking buscarPorId(@PathVariable int id) {
        try {
            return rankingService.buscarRanking(id);
        }
        catch(RankingNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/vagas/{idVaga}")
    public Ranking buscarPorVaga(@PathVariable int idVaga) {
        try {
            return rankingService.buscarRankingPorVaga(idVaga);
        }
        catch(RankingNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
