package br.com.carolina.venturahr_web.model.service;

import br.com.carolina.venturahr_web.model.domain.Candidatura;
import br.com.carolina.venturahr_web.model.domain.Usuario;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import br.com.carolina.venturahr_web.model.error.MensagemErro;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CandidaturaService {
    private final String URL = "http://localhost:8084/api"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public void Candidatar(Candidatura candidatura) {
        Response response = client
                .target(URL + "/candidaturas")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(candidatura, MediaType.APPLICATION_JSON));

        if (response.getStatus()!= 200) {
            StringBuilder mensagem = MensagemErro.BuscarMensagemErro(response);
            throw new ErroNaAutenticacaoException(mensagem.toString());
        }
    }


}
