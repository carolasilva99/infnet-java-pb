package br.com.carolina.venturahr_vaga.model.service;

import br.com.carolina.venturahr_vaga.model.domain.Ranking;
import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.exception.RankingNaoEncontradoException;
import br.com.carolina.venturahr_vaga.model.infra.SortByPmd;
import br.com.carolina.venturahr_vaga.model.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankingService {
    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private VagaService vagaService;

   public Ranking inserirRanking(Ranking ranking) {
       return rankingRepository.save(ranking);
   }

   public Ranking buscarRanking(int id) {
       Optional<Ranking> optionalRanking = rankingRepository.findById(id);

       if (optionalRanking.isEmpty()) {
           throw new RankingNaoEncontradoException("O ranking com id " + id + " não foi encontrado!");
       }

       Ranking ranking = optionalRanking.get();
       ranking.getCandidaturas().sort(new SortByPmd());

       return ranking;
   }
}
