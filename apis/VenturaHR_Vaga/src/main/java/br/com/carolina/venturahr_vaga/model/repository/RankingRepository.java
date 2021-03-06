package br.com.carolina.venturahr_vaga.model.repository;

import br.com.carolina.venturahr_vaga.model.domain.Ranking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RankingRepository extends CrudRepository<Ranking, Integer> {
    Optional<Ranking> findByVagaId(int idVaga);
}
