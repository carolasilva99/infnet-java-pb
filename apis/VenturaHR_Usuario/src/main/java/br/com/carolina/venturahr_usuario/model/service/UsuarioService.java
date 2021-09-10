package br.com.carolina.venturahr_usuario.model.service;

import br.com.carolina.venturahr_usuario.model.domain.Usuario;
import br.com.carolina.venturahr_usuario.model.domain.dto.AlterarUsuarioDto;
import br.com.carolina.venturahr_usuario.model.domain.enums.StatusUsuario;
import br.com.carolina.venturahr_usuario.model.exception.CampoDuplicadoException;
import br.com.carolina.venturahr_usuario.model.exception.UsuarioNaoEncontradoException;
import br.com.carolina.venturahr_usuario.model.infra.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validaUsuario(Usuario usuario) {
        verificaDuplicidadeEmail(usuario.getEmail());
    }

    private void verificaDuplicidadeEmail(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new CampoDuplicadoException("O email " + email + " já está cadastrado na nossa base!");
        }
    }

    public void alterarStatus(AlterarUsuarioDto usuario, int id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Não foi encontrado um usuário com o id " + id);
        }

        Usuario antigo = usuarioOptional.get();
        StatusUsuario novoStatus = StatusUsuario.from(usuario.getStatus());
        antigo.setStatus(novoStatus);

        usuarioRepository.save(antigo);
    }
}
