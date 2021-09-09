package br.com.carolina.venturahr_usuario.model.infra.repository;

import br.com.carolina.venturahr_usuario.model.domain.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    boolean existsByCnpj(String cnpj);

    Optional<Empresa> findByCnpj(String cnpj);
}
