package br.com.carolina.venturahr_usuario.model.service;

import br.com.carolina.venturahr_usuario.model.domain.Candidato;
import br.com.carolina.venturahr_usuario.model.domain.enums.StatusUsuario;
import br.com.carolina.venturahr_usuario.model.domain.enums.TipoUsuario;
import br.com.carolina.venturahr_usuario.model.exception.CpfDuplicadoException;
import br.com.carolina.venturahr_usuario.model.exception.UsuarioNaoEncontrado;
import br.com.carolina.venturahr_usuario.model.infra.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatoService {
    @Autowired
    private CandidatoRepository candidatoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Candidato incluir(Candidato candidato) {
        validaCandidato(candidato);
        candidato.setTipo(TipoUsuario.CANDIDATO);
        candidato.setStatus(StatusUsuario.DESBLOQUEADO);
        return candidatoRepository.save(candidato);
    }

    private void validaCandidato(Candidato candidato) {
        usuarioService.validaUsuario(candidato);
        verificaDuplicidadeCpf(candidato.getCpf());
    }

    private void verificaDuplicidadeCpf(String cpf) {
        if (candidatoRepository.existsByCpf(cpf)) {
            throw new CpfDuplicadoException("O cpf " + cpf + " já existe em nossa base!");
        }
    }

    public Iterable<Candidato> listar() {
        return candidatoRepository.findAll();
    }

    public Candidato buscarPorId(int id) {
        return candidatoRepository
                .findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontrado("O candidato com o id " + id + " não foi encontrado"));
    }

    public Candidato buscarPorCpf(String cpf) {
        return candidatoRepository
                .findByCpf(cpf)
                .orElseThrow(() -> new UsuarioNaoEncontrado("O candidato com o cpf " + cpf + " não foi encontrado"));
    }
}
