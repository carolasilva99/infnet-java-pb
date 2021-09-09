package br.com.carolina.venturahr_web;

import br.com.carolina.venturahr_web.model.domain.Usuario;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import br.com.carolina.venturahr_web.model.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        LoginService loginService = new LoginService();
        Usuario autenticar = new Usuario();
        autenticar.setEmail(email);
        autenticar.setSenha(senha);

        try {
            Usuario usuarioLogado = loginService.login(autenticar);

            req.setAttribute("tipo", usuarioLogado.getTipo());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cadastro-empresa.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch(ErroNaAutenticacaoException ex) {
            req.setAttribute("mensagem_erro", ex.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }

    public void destroy() {
    }
}