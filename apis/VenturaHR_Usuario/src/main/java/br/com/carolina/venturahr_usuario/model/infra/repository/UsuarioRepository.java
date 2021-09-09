package br.com.carolina.venturahr_usuario.model.infra.repository;

import br.com.carolina.venturahr_usuario.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
}
