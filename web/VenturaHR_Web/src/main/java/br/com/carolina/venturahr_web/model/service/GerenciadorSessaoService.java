package br.com.carolina.venturahr_web.model.service;

import br.com.carolina.venturahr_web.model.domain.enums.TipoUsuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GerenciadorSessaoService {
    public static int usuarioLogado(HttpServletRequest req, HttpServletResponse resp, TipoUsuario tipo) throws ServletException, IOException {
        try {
            int idUsuario = (int) req.getSession().getAttribute("usuarioId");
            TipoUsuario tipoUsuario = (TipoUsuario) req.getSession().getAttribute("tipo");

            if (tipoUsuario != null && !tipoUsuario.equals(tipo)) {
                throw new Exception("Usuário não tem autorização para acessar essa tela!");
            }

            return idUsuario;
        }
        catch (Exception exception) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req, resp);
        }

        return 0;
    }
}
