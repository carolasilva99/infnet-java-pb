package br.com.carolina.venturahr_web.model.service;


import br.com.carolina.venturahr_web.model.domain.Ranking;
import br.com.carolina.venturahr_web.model.domain.Vaga;
import br.com.carolina.venturahr_web.model.error.ErroApiException;
import br.com.carolina.venturahr_web.model.error.MensagemErro;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class RankingService {
    private final String URL = "http://localhost:8083/api"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public Ranking buscarRanking(int idVaga) {
        Response response = client
                .target(URL + "/rankings/vagas/" + idVaga)
                .request().get();

        if (response.getStatus() == 200) {
            return response.readEntity(Ranking.class);
        }
        else {
            StringBuilder mensagem = MensagemErro.BuscarMensagemErro(response);
            throw new ErroApiException(mensagem.toString());
        }
    }
}
