package br.com.carolina.venturahr_web.model.service;


import br.com.carolina.venturahr_web.model.domain.Erro;
import br.com.carolina.venturahr_web.model.domain.Usuario;
import br.com.carolina.venturahr_web.model.domain.Vaga;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class VagaService {
    private final String URL = "http://localhost:8083/api"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public List<Vaga> buscarVagas(String cargo, Integer empresaId, String status) {
        Response response = client
                .target(URL + "/vagas")
                .queryParam("cargo", cargo)
                .queryParam("empresaId", empresaId)
                .queryParam("status", status)
                .request().get();

        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<List<Vaga>>() {});
        }
        else if (response.getStatus() == 404) {
            Erro erro = response.readEntity(Erro.class);
            throw new ErroNaAutenticacaoException(erro.getMessage());
        }


        throw new ErroNaAutenticacaoException("Erro inesperado! Verifique os logs");
    }
}
