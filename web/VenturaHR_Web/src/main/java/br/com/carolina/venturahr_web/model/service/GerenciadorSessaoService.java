package br.com.carolina.venturahr_web.model.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GerenciadorSessaoService {
    public static int usuarioLogado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            return (int) req.getSession().getAttribute("usuarioId");
        }
        catch (Exception exception) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req, resp);
        }

        return 0;
    }
}
