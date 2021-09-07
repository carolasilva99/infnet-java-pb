package br.com.carolina.venturahr_usuario.controller;

import br.com.carolina.venturahr_usuario.model.domain.Empresa;
import br.com.carolina.venturahr_usuario.model.exception.CampoDuplicadoException;
import br.com.carolina.venturahr_usuario.model.exception.UsuarioNaoEncontradoException;
import br.com.carolina.venturahr_usuario.model.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public Empresa incluir(@Valid @RequestBody Empresa empresa) {
        try {
            return empresaService.incluir(empresa);
        }
        catch(CampoDuplicadoException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping
    public Iterable<Empresa> listar() {
        try {
            return empresaService.listar();
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Empresa buscarPorId(@PathVariable int id) {
        try {
            return empresaService.buscarPorId(id);
        }
        catch(UsuarioNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/cnpj/{cnpj}")
    public Empresa buscarPorCnpj(@PathVariable String cnpj) {
        try {
            return empresaService.buscarPorCnpj(cnpj);
        }
        catch(UsuarioNaoEncontradoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
