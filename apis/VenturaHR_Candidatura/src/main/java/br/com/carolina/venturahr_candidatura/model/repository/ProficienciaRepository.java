package br.com.carolina.venturahr_candidatura.model.repository;

import br.com.carolina.venturahr_candidatura.model.domain.Candidatura;
import br.com.carolina.venturahr_candidatura.model.domain.Proficiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficienciaRepository extends CrudRepository<Proficiencia, Integer> {
}
