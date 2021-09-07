package br.com.carolina.venturahr_autenticacao.controller;

import br.com.carolina.venturahr_autenticacao.model.domain.Usuario;
import br.com.carolina.venturahr_autenticacao.model.exception.UsuarioOuSenhaInvalidosException;
import br.com.carolina.venturahr_autenticacao.model.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
public class AutenticacaoController {
    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public Usuario login(@RequestBody Usuario usuario) {
        try {
            return autenticacaoService.login(usuario);
        }
        catch(UsuarioOuSenhaInvalidosException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }

    }
}
