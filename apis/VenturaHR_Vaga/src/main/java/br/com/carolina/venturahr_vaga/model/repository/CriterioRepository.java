package br.com.carolina.venturahr_vaga.model.repository;

import br.com.carolina.venturahr_vaga.model.domain.Criterio;
import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterioRepository extends CrudRepository<Criterio, Integer> {
}
