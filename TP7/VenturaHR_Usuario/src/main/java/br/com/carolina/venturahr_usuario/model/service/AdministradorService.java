package br.com.carolina.venturahr_usuario.model.service;

import br.com.carolina.venturahr_usuario.model.domain.Administrador;
import br.com.carolina.venturahr_usuario.model.domain.enums.StatusUsuario;
import br.com.carolina.venturahr_usuario.model.exception.UsuarioNaoEncontrado;
import br.com.carolina.venturahr_usuario.model.infra.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AdministradorRepository administradorRepository;

    public Administrador incluir(Administrador administrador) {
        validaAdministrador(administrador);
        administrador.setStatus(StatusUsuario.DESBLOQUEADO);
        return administradorRepository.save(administrador);
    }

    private void validaAdministrador(Administrador administrador) {
        usuarioService.validaUsuario(administrador);
    }

    public Iterable<Administrador> listar() {
        return administradorRepository.findAll();
    }

    public Administrador buscarPorId(int id) {
        return administradorRepository
                .findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontrado("O administrador com id " + id + " não foi encontrado"));
    }

    public Administrador buscarPorEmail(String email) {
        return administradorRepository
                .findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoEncontrado("O administrador com e-mail " + email + " não foi encontrado"));
    }
}
