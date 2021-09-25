package br.com.carolina.venturahr_web.model.service;

import br.com.carolina.venturahr_web.model.domain.Candidato;
import br.com.carolina.venturahr_web.model.error.ErroApiException;
import br.com.carolina.venturahr_web.model.error.MensagemErro;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CadastroCandidatoService {
    private final String URL = "http://localhost:8081/api"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public void cadastro(Candidato candidato) {
            Response response = client
                    .target(URL + "/candidatos")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(candidato, MediaType.APPLICATION_JSON));

            if (response.getStatus() != 200) {
                StringBuilder mensagem = MensagemErro.BuscarMensagemErro(response);
                throw new ErroApiException(mensagem.toString());
            }
    }
}
