package br.com.carolina.venturahr_autenticacao.model.service;

import br.com.carolina.venturahr_autenticacao.model.domain.Usuario;
import br.com.carolina.venturahr_autenticacao.model.exception.UsuarioOuSenhaInvalidosException;
import br.com.carolina.venturahr_autenticacao.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutenticacaoService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(Usuario usuario) {
        return usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha())
                .orElseThrow(() -> new UsuarioOuSenhaInvalidosException("Usuário ou senha inválidos!"));
    }
}
