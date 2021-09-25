package br.com.carolina.venturahr_vaga.model.infra;

import br.com.carolina.venturahr_vaga.model.domain.Candidatura;
import br.com.carolina.venturahr_vaga.model.domain.Ranking;
import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.domain.enums.StatusVaga;
import br.com.carolina.venturahr_vaga.model.service.CandidaturaService;
import br.com.carolina.venturahr_vaga.model.service.RankingService;
import br.com.carolina.venturahr_vaga.model.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class ExpiracaoVagaScheduler {
    @Autowired
    private VagaService vagaService;

    @Autowired
    private CandidaturaService candidaturaService;

    @Autowired
    private RankingService rankingService;

    @Scheduled(fixedDelay = 3600)
    public void expirarVagas() {
        try {
            List<Vaga> vagasExpiradas = vagaService.buscarVagasParaExpiracao();
            for(Vaga vaga : vagasExpiradas) {
                vaga = vagaService.buscarPorId(vaga.getId());
                vaga.setStatus(StatusVaga.EXPIRADA);
                vagaService.salvar(vaga);
                gerarRanking(vaga);
            }
        }
        catch (Exception exception) {
            System.out.println("Erro no scheduler: " + exception.getMessage());
        }
    }

    private void gerarRanking(Vaga vaga) {
        Ranking ranking = new Ranking();
        ranking.setVaga(vaga);
        List<Candidatura> candidaturas = candidaturaService.buscarPorVaga(vaga.getId());
        ranking.setCandidaturas(candidaturas);

        Ranking salvo = rankingService.inserirRanking(ranking);
        System.out.println("O ranking " + salvo.getId() + " foi salvo! Consulte utilizando o id!");
    }

    @Scheduled(fixedDelay = 3600)
    public void finalizarVagas() {
        try {
            List<Vaga> vagasExpiradas = vagaService.buscarVagasParaFinalizacao();
            for(Vaga vaga : vagasExpiradas) {
                vaga = vagaService.buscarPorId(vaga.getId());
                vaga.setStatus(StatusVaga.FINALIZADA);
                vagaService.salvar(vaga);
            }
        }
        catch (Exception exception) {
            System.out.println("Erro no scheduler: " + exception.getMessage());
        }
    }
}
