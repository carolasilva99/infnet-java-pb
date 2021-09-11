package br.com.carolina.venturahr_vaga.controller;

import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.domain.dto.AlterarStatusDto;
import br.com.carolina.venturahr_vaga.model.exception.StatusInvalidoException;
import br.com.carolina.venturahr_vaga.model.exception.VagaNaoEncontradaException;
import br.com.carolina.venturahr_vaga.model.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @PostMapping
    public Vaga cadastrar(@Valid @RequestBody Vaga vaga) {
        try {
            return vagaService.incluir(vaga);
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Vaga buscarPorId(@PathVariable int id) {
        try {
            return vagaService.buscarPorId(id);
        }
        catch(VagaNaoEncontradaException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping
    public List<Vaga> listar(String cargo, Integer empresaId, String status) {
        try {
            return vagaService.listar(cargo, empresaId, status);
        }
        catch(StatusInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public void alterarStatus(@PathVariable int id, @RequestBody AlterarStatusDto statusAlterar) {
        try {
            vagaService.alterarStatus(id, statusAlterar);
        }
        catch(VagaNaoEncontradaException | StatusInvalidoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }

    }

    @GetMapping("/expiradas")
    public List<Vaga> buscarVagasExpiradas() {
        try {
            return vagaService.buscarVagasExpiradas();
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
