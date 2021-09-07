package br.com.carolina.venturahr_usuario.model.infra.repository;

import br.com.carolina.venturahr_usuario.model.domain.Candidato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer> {
    boolean existsByCpf(String cpf);

    Optional<Candidato> findByCpf(String cpf);
}
