package br.com.carolina.venturahr_candidatura.model.repository;

import br.com.carolina.venturahr_candidatura.model.domain.Criterio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterioRepository extends CrudRepository<Criterio, Integer> {
}
