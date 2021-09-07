package br.com.carolina.venturahr_usuario.controller;

import br.com.carolina.venturahr_usuario.model.domain.Candidato;
import br.com.carolina.venturahr_usuario.model.exception.CpfDuplicadoException;
import br.com.carolina.venturahr_usuario.model.exception.EmailDuplicadoException;
import br.com.carolina.venturahr_usuario.model.exception.UsuarioNaoEncontrado;
import br.com.carolina.venturahr_usuario.model.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {
    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public Candidato incluir(@Valid @RequestBody Candidato candidato) {
        try {
            return candidatoService.incluir(candidato);
        }
        catch(CpfDuplicadoException | EmailDuplicadoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping
    public Iterable<Candidato> listar() {
        try {
            return candidatoService.listar();
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Candidato buscarPorId(@PathVariable int id) {
        try {
            return candidatoService.buscarPorId(id);
        }
        catch(UsuarioNaoEncontrado ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/cpf/{cpf}")
    public Candidato buscarPorCpf(@PathVariable String cpf) {
        try {
            return candidatoService.buscarPorCpf(cpf);
        }
        catch(UsuarioNaoEncontrado ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
