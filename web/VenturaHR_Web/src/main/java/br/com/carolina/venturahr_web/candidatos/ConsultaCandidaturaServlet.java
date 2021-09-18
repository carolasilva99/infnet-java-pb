package br.com.carolina.venturahr_web.candidatos;

import br.com.carolina.venturahr_web.model.domain.Candidatura;
import br.com.carolina.venturahr_web.model.domain.Vaga;
import br.com.carolina.venturahr_web.model.domain.enums.StatusVaga;
import br.com.carolina.venturahr_web.model.domain.enums.TipoUsuario;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import br.com.carolina.venturahr_web.model.service.CandidaturaService;
import br.com.carolina.venturahr_web.model.service.GerenciadorSessaoService;
import br.com.carolina.venturahr_web.model.service.VagaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ConsultaCandidaturaServlet", value = "/consulta-candidatura")
public class ConsultaCandidaturaServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            int usuarioId = GerenciadorSessaoService.usuarioLogado(req, resp, TipoUsuario.CANDIDATO);

            CandidaturaService candidaturaService = new CandidaturaService();

            List<Candidatura> candidaturas = candidaturaService.buscarCandidaturas(usuarioId);
            req.setAttribute("candidaturas", candidaturas);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("candidatos/consulta-candidaturas.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ErroNaAutenticacaoException exception) {
            req.setAttribute("mensagem_erro", exception.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }
}