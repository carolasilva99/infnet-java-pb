package br.com.carolina.venturahr_web.empresas;

import br.com.carolina.venturahr_web.model.domain.Vaga;
import br.com.carolina.venturahr_web.model.domain.enums.StatusVaga;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import br.com.carolina.venturahr_web.model.service.GerenciadorSessaoService;
import br.com.carolina.venturahr_web.model.service.VagaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ConsultaVagaEmpresaServlet", value = "/consulta-vaga-empresa")
public class ConsultaVagaEmpresaServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            int idEmpresa = GerenciadorSessaoService.usuarioLogado(req, resp);
            String status = req.getParameter("status");
            String cargo = req.getParameter("cargo");

            VagaService vagaService = new VagaService();

            List<Vaga> vagas = vagaService.buscarVagas(cargo, idEmpresa, status);
            req.setAttribute("vagas", vagas);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("empresas/consulta-vagas.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ErroNaAutenticacaoException exception) {
            req.setAttribute("mensagem_erro", exception.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }
}