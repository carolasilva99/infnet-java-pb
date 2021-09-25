package br.com.carolina.venturahr_web.candidatos;

import br.com.carolina.venturahr_web.model.domain.*;
import br.com.carolina.venturahr_web.model.domain.enums.TipoUsuario;
import br.com.carolina.venturahr_web.model.error.ErroApiException;
import br.com.carolina.venturahr_web.model.service.CandidaturaService;
import br.com.carolina.venturahr_web.model.service.GerenciadorSessaoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetalheCandidaturaServlet", value = "/detalhe-candidatura")
public class DetalheCandidaturaServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            GerenciadorSessaoService.usuarioLogado(req, resp, TipoUsuario.CANDIDATO);
            CandidaturaService candidaturaService = new CandidaturaService();
            String id = req.getParameter("id");
            Candidatura candidatura = candidaturaService.buscarCandidatura(Integer.parseInt(id));
            req.setAttribute("candidatura", candidatura);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("candidatos/detalhe-candidatura.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ErroApiException exception) {
            req.setAttribute("mensagem_erro", exception.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }


}