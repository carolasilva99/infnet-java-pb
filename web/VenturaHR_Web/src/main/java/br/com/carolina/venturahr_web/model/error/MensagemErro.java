package br.com.carolina.venturahr_web.model.error;

import br.com.carolina.venturahr_web.model.domain.Erro;
import br.com.carolina.venturahr_web.model.domain.ErroValidacao;
import jakarta.ws.rs.core.Response;

public class MensagemErro {
    public static StringBuilder BuscarMensagemErro(Response response) {
        Erro erro = response.readEntity(Erro.class);
        StringBuilder mensagem = new StringBuilder();
        if (erro.getErrors() != null && !erro.getErrors().isEmpty()) {
            for (ErroValidacao erroValidacao : erro.getErrors()) {
                mensagem.append(" | ").append(erroValidacao.getDefaultMessage());
            }
        }
        else {
            mensagem.append(erro.getMessage());
        }

        return mensagem;
    }
}
