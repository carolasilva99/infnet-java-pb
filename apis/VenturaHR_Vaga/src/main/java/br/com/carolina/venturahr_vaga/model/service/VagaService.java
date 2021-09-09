package br.com.carolina.venturahr_vaga.model.service;

import br.com.carolina.venturahr_vaga.model.domain.Criterio;
import br.com.carolina.venturahr_vaga.model.domain.Empresa;
import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.domain.enums.StatusVaga;
import br.com.carolina.venturahr_vaga.model.exception.VagaNaoEncontradaException;
import br.com.carolina.venturahr_vaga.model.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private CriterioService criterioService;

    public Vaga incluir(Vaga vaga) {
        Vaga vagaSalva = vagaRepository.save(vaga);
        for (Criterio criterio : vaga.getCriterios()) {
            criterio.setVaga(vagaSalva);
        }
        criterioService.incluirVarios(vaga.getCriterios());
        return vagaSalva;
    }

    public Vaga buscarPorId(int id) {
        return vagaRepository
                .findById(id)
                .orElseThrow(() -> new VagaNaoEncontradaException("A vaga com o id " + id + " não foi encontrada"));
    }

    public List<Vaga> listar(String cargo, String descricaoCriterio, Integer empresaId, String status) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAny()
                .withMatcher("cargo", contains().ignoreCase());
        Vaga exemplo = Vaga
                .builder()
                .cargo(cargo)
                .empresa(new Empresa(empresaId))
                .status(StatusVaga.from(status))
                .criterios(Collections.singletonList(new Criterio(descricaoCriterio)))
                .build();
        return vagaRepository.findAll(Example.of(exemplo, matcher));
    }
}
