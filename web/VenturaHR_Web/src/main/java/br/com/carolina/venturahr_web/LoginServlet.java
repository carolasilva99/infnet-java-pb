package br.com.carolina.venturahr_web;

import br.com.carolina.venturahr_web.model.domain.Usuario;
import br.com.carolina.venturahr_web.model.error.ErroApiException;
import br.com.carolina.venturahr_web.model.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.getSession().invalidate();
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

            req.getSession().setAttribute("usuarioId", usuarioLogado.getId());
            req.getSession().setAttribute("tipo", usuarioLogado.getTipo());

            RequestDispatcher requestDispatcher;

            switch(usuarioLogado.getTipo()) {
                case ADMIN:
                     requestDispatcher = req.getRequestDispatcher("admins/consulta-vagas.jsp");
                     break;
                case CANDIDATO:
                    requestDispatcher = req.getRequestDispatcher("candidatos/consulta-vagas.jsp");
                    break;
                case EMPRESA:
                    requestDispatcher = req.getRequestDispatcher("empresas/consulta-vagas.jsp");
                    break;
                default:
                    requestDispatcher = req.getRequestDispatcher("/");
                    break;
            }

            requestDispatcher.forward(req, resp);
        }
        catch(ErroApiException ex) {
            req.setAttribute("mensagem_erro", ex.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }

    public void destroy() {
    }
}