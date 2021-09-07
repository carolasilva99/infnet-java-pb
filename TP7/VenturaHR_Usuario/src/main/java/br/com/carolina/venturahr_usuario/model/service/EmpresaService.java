package br.com.carolina.venturahr_usuario.model.service;

import br.com.carolina.venturahr_usuario.model.domain.Empresa;
import br.com.carolina.venturahr_usuario.model.domain.enums.StatusUsuario;
import br.com.carolina.venturahr_usuario.model.exception.CampoDuplicadoException;
import br.com.carolina.venturahr_usuario.model.exception.UsuarioNaoEncontradoException;
import br.com.carolina.venturahr_usuario.model.infra.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa incluir(Empresa empresa) {
        validaEmpresa(empresa);
        empresa.setStatus(StatusUsuario.DESBLOQUEADO);
        return empresaRepository.save(empresa);
    }

    private void validaEmpresa(Empresa empresa) {
        usuarioService.validaUsuario(empresa);
        verificaDuplicidadeCnpj(empresa.getCnpj());
    }

    private void verificaDuplicidadeCnpj(String cnpj) {
        if (empresaRepository.existsByCnpj(cnpj)) {
            throw new CampoDuplicadoException("O cnpj " + cnpj + " já existe em nossa base!");
        }
    }

    public Iterable<Empresa> listar() {
        return empresaRepository.findAll();
    }

    public Empresa buscarPorId(int id) {
        return empresaRepository
                .findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("A empresa com o id " + id + " não foi encontrada"));
    }

    public Empresa buscarPorCnpj(String cnpj) {
        return empresaRepository
                .findByCnpj(cnpj)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("A empresa com o cnpj " + cnpj + " não foi encontrada"));
    }
}
