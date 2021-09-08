package br.com.carolina.venturahr_web.model.service;


import br.com.carolina.venturahr_web.model.domain.Usuario;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientResponse;

public class LoginService {
    private final String URL = "http://localhost:8082/api"; //System.getProperty("URL_AUTENTICACAO");
    private final Client client = ClientBuilder.newClient();

    public Usuario login(Usuario usuario) {
            Response response = client
                    .target(URL + "/login")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(usuario, MediaType.APPLICATION_JSON));

            if (response.getStatus() == 200) {
                return response.readEntity(Usuario.class);
            }

            throw new ErroNaAutenticacaoException("teste");
    }
}
