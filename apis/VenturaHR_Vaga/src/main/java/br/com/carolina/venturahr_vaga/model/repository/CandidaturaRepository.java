package br.com.carolina.venturahr_vaga.model.repository;

import br.com.carolina.venturahr_vaga.model.domain.Candidatura;
import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidaturaRepository extends JpaRepository<Candidatura, Integer> {
    List<Candidatura> findAllByVaga(Vaga vaga);
}
