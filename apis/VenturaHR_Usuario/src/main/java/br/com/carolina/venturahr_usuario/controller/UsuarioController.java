package br.com.carolina.venturahr_usuario.controller;

import br.com.carolina.venturahr_usuario.model.domain.Empresa;
import br.com.carolina.venturahr_usuario.model.domain.Usuario;
import br.com.carolina.venturahr_usuario.model.domain.dto.AlterarUsuarioDto;
import br.com.carolina.venturahr_usuario.model.exception.CampoDuplicadoException;
import br.com.carolina.venturahr_usuario.model.exception.StatusNaoEncontradoException;
import br.com.carolina.venturahr_usuario.model.exception.UsuarioNaoEncontradoException;
import br.com.carolina.venturahr_usuario.model.service.EmpresaService;
import br.com.carolina.venturahr_usuario.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PatchMapping("/{id}")
    public void alterarStatusUsuario(@RequestBody AlterarUsuarioDto usuario, @PathVariable int id) {
        try {
            usuarioService.alterarStatus(usuario, id);
        }
        catch(UsuarioNaoEncontradoException | StatusNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
