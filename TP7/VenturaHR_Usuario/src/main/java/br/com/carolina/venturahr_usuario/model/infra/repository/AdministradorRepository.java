package br.com.carolina.venturahr_usuario.model.infra.repository;

import br.com.carolina.venturahr_usuario.model.domain.Administrador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, Integer> {
}
