package br.com.carolina.venturahr_autenticacao.model.repository;

import br.com.carolina.venturahr_autenticacao.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
