package br.com.carolina.venturahr_web.model.service;

import br.com.carolina.venturahr_web.model.domain.Candidatura;
import br.com.carolina.venturahr_web.model.domain.Usuario;
import br.com.carolina.venturahr_web.model.domain.Vaga;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import br.com.carolina.venturahr_web.model.error.MensagemErro;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

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

    public List<Candidatura> buscarCandidaturas(int idUsuario) {
        Response response = client
                .target(URL + "/candidaturas/usuarios/" + idUsuario)
                .request().get();

        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<List<Candidatura>>() {});
        }
        else {
            StringBuilder mensagem = MensagemErro.BuscarMensagemErro(response);
            throw new ErroNaAutenticacaoException(mensagem.toString());
        }
    }

    public Candidatura buscarCandidatura(int id) {
        Response response = client
                .target(URL + "/candidaturas/" + id)
                .request().get();

        if (response.getStatus() == 200) {
            return response.readEntity(Candidatura.class);
        }
        else {
            StringBuilder mensagem = MensagemErro.BuscarMensagemErro(response);
            throw new ErroNaAutenticacaoException(mensagem.toString());
        }
    }
}
