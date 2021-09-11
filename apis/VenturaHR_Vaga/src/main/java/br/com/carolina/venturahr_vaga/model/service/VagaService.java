package br.com.carolina.venturahr_vaga.model.service;

import br.com.carolina.venturahr_vaga.model.domain.Criterio;
import br.com.carolina.venturahr_vaga.model.domain.Empresa;
import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.domain.dto.AlterarStatusDto;
import br.com.carolina.venturahr_vaga.model.domain.enums.StatusVaga;
import br.com.carolina.venturahr_vaga.model.exception.StatusInvalidoException;
import br.com.carolina.venturahr_vaga.model.exception.VagaNaoEncontradaException;
import br.com.carolina.venturahr_vaga.model.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class VagaService {
    private static final long TEMPO_EXPIRACAO_EM_DIAS = 1;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private CriterioService criterioService;

    public Vaga incluir(Vaga vaga) {
        vaga.setDataInicio(LocalDateTime.now());
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

    public List<Vaga> listar(String cargo, Integer empresaId, String status) {
        ExampleMatcher matcher = ExampleMatcher
                .matchingAny()
                .withMatcher("cargo", contains().ignoreCase());
        Vaga exemplo = Vaga
                .builder()
                .cargo(cargo)
                .empresa(new Empresa(empresaId))
                .status(StatusVaga.from(status))
                .build();
        return vagaRepository.findAll(Example.of(exemplo, matcher));
    }

    public void alterarStatus(int id, AlterarStatusDto statusAlterar) {
        Optional<Vaga> vagaOptional = vagaRepository.findById(id);

        if (vagaOptional.isEmpty()) {
            throw new VagaNaoEncontradaException("A vaga com o id " + id + " não foi encontrada");
        }
        StatusVaga status = StatusVaga.from(statusAlterar.getStatus());
        if (status == null) {
            throw new StatusInvalidoException("O status " + statusAlterar.getStatus() + " não foi encontrado");
        }

        Vaga vaga = vagaOptional.get();
        vaga.setStatus(status);
        vagaRepository.save(vaga);
    }

    public List<Vaga> buscarVagasExpiradas() {
        LocalDateTime tempoLimiteParaExpiracao = LocalDateTime.now().minusDays(TEMPO_EXPIRACAO_EM_DIAS);
        return vagaRepository.findAllByDataInicioBefore(tempoLimiteParaExpiracao);
    }

    public void salvarTodas(List<Vaga> vagas) {
        vagaRepository.saveAll(vagas);
    }
}
