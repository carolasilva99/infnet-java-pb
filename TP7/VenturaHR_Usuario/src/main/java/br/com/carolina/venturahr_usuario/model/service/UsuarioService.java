package br.com.carolina.venturahr_usuario.model.service;

import br.com.carolina.venturahr_usuario.model.domain.Usuario;
import br.com.carolina.venturahr_usuario.model.exception.EmailDuplicadoException;
import br.com.carolina.venturahr_usuario.model.infra.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validaUsuario(Usuario usuario) {
        verificaDuplicidadeEmail(usuario.getEmail());
    }

    private void verificaDuplicidadeEmail(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new EmailDuplicadoException("O email " + email + " já está cadastrado na nossa base!");
        }
    }
}
