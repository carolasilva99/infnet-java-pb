package br.com.carolina.venturahr_web.empresas;

import br.com.carolina.venturahr_web.model.domain.*;
import br.com.carolina.venturahr_web.model.domain.enums.PMDCandidatura;
import br.com.carolina.venturahr_web.model.domain.enums.StatusVaga;
import br.com.carolina.venturahr_web.model.domain.enums.TipoUsuario;
import br.com.carolina.venturahr_web.model.error.ErroApiException;
import br.com.carolina.venturahr_web.model.service.CandidaturaService;
import br.com.carolina.venturahr_web.model.service.GerenciadorSessaoService;
import br.com.carolina.venturahr_web.model.service.RankingService;
import br.com.carolina.venturahr_web.model.service.VagaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "DetalheVagaEmpresaServlet", value = "/detalhe-vaga-empresa")
public class DetalheVagaEmpresaServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            GerenciadorSessaoService.usuarioLogado(req, resp, TipoUsuario.EMPRESA);
            VagaService vagaService = new VagaService();
            String id = req.getParameter("id");

            Vaga vaga = vagaService.buscarVaga(Integer.parseInt(id));

            if (vaga.getStatus() == StatusVaga.EXPIRADA || vaga.getStatus() == StatusVaga.FINALIZADA) {
                RankingService rankingService = new RankingService();
                Ranking ranking = rankingService.buscarRanking(vaga.getId());
                req.setAttribute("ranking", ranking);
            }

            req.setAttribute("vaga", vaga);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("empresas/detalhe-vaga.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ErroApiException exception) {
            req.setAttribute("mensagem_erro", exception.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usuarioId = GerenciadorSessaoService.usuarioLogado(req, resp, TipoUsuario.EMPRESA);
        CandidaturaService candidaturaService = new CandidaturaService();

        try {
            Candidatura candidatura = criaCandidaturaAPartirDosParametrosEnviados(usuarioId, req.getParameterMap());

            candidaturaService.Candidatar(candidatura);

            req.setAttribute("mensagem_sucesso", "Candidatura efetivada com sucesso!");
            req.setAttribute("mensagem_sucesso", "Candidatura efetivada com sucesso!");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("candidatos/consulta-vagas.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ErroApiException exception) {
            req.setAttribute("mensagem_erro", exception.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/candidatos/detalhe-vaga.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private Candidatura criaCandidaturaAPartirDosParametrosEnviados(int usuarioId, Map<String, String[]> parameters) {
        Candidatura candidatura = new Candidatura();
        Candidato candidato = new Candidato(usuarioId);
        Vaga vaga = new Vaga(Integer.parseInt(parameters.get("vaga.id")[0]));

        List<Proficiencia> proficiencias = new ArrayList<>();

        for (Map.Entry<String, String[]> proficiencia : parameters.entrySet()) {
            if (proficiencia.getKey().contains("proficiencias")) {
                String criterioId = proficiencia.getKey().split("\\.")[1];
                Criterio criterio = new Criterio(Integer.parseInt(criterioId));
                Proficiencia p = new Proficiencia();
                p.setCriterio(criterio);
                p.setNota(PMDCandidatura.valueOf(proficiencia.getValue()[0]));
                proficiencias.add(p);
            }
        }

        candidatura.setCandidato(candidato);
        candidatura.setVaga(vaga);
        candidatura.setProficiencias(proficiencias);

        return candidatura;
    }

}