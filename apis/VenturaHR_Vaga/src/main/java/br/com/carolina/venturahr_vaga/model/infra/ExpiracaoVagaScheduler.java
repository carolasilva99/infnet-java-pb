package br.com.carolina.venturahr_vaga.model.infra;

import br.com.carolina.venturahr_vaga.model.domain.Vaga;
import br.com.carolina.venturahr_vaga.model.domain.enums.StatusVaga;
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

    @Scheduled(fixedDelay = 3600)
    public void expirarVagas() {
        try {
            List<Vaga> vagasExpiradas = vagaService.buscarVagasExpiradas();
            for(Vaga vaga : vagasExpiradas) {
                vaga.setStatus(StatusVaga.EXPIRADA);
            }
            vagaService.salvarTodas(vagasExpiradas);
        }
        catch (Exception exception) {
            System.out.println("Erro no scheduler: " + exception.getMessage());
        }
    }
}
