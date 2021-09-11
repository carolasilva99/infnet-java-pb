package br.com.carolina.venturahr_candidatura.model.repository;

import br.com.carolina.venturahr_candidatura.model.domain.Candidato;
import br.com.carolina.venturahr_candidatura.model.domain.Candidatura;
import br.com.carolina.venturahr_candidatura.model.domain.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {
    List<Candidatura> findAllByCandidato(Candidato candidato);

    List<Candidatura> findAllByVaga(Vaga vaga);
}
