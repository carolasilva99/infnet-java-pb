package br.com.carolina.venturahr_web.empresas;

import br.com.carolina.venturahr_web.model.domain.*;
import br.com.carolina.venturahr_web.model.domain.enums.PMD;
import br.com.carolina.venturahr_web.model.domain.enums.PMDCandidatura;
import br.com.carolina.venturahr_web.model.domain.enums.TipoUsuario;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import br.com.carolina.venturahr_web.model.service.CandidaturaService;
import br.com.carolina.venturahr_web.model.service.GerenciadorSessaoService;
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

@WebServlet(name = "CadastroVagaServlet", value = "/cadastro-vaga")
public class CadastroVagaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("quantidadeCriterios", 1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empresaId = GerenciadorSessaoService.usuarioLogado(req, resp, TipoUsuario.EMPRESA);
        VagaService vagaService = new VagaService();

        try {
            Vaga vaga = criaVagaAPartirDosParametrosEnviados(empresaId, req.getParameterMap());
            vagaService.cadastro(vaga);

            req.setAttribute("mensagem_sucesso", "Vaga cadastrada com sucesso!");

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("empresas/consulta-vagas.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch (ErroNaAutenticacaoException exception) {
            req.setAttribute("mensagem_erro", exception.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/empresas/cadastro-vaga.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private Vaga criaVagaAPartirDosParametrosEnviados(int empresaId, Map<String, String[]> parameters) {
        Vaga vaga = new Vaga();
        Empresa empresa = new Empresa(empresaId);

        vaga.setEmpresa(empresa);
        vaga.setCargo(parameters.get("cargo")[0]);

        List<Criterio> criterios = new ArrayList<>();

        String[] nomes = null;
        String[] descricoes = null;
        String[] pmds = null;
        String[] pesos = null;

        for (Map.Entry<String, String[]> criterio : parameters.entrySet()) {
            if (criterio.getKey().contains("criterios.nome")) {
                nomes = criterio.getValue();
            }
            else if (criterio.getKey().contains("criterios.descricao")) {
                descricoes = criterio.getValue();
            }
            else if (criterio.getKey().contains("criterios.pmd")) {
                pmds = criterio.getValue();
            }
            else if (criterio.getKey().contains("criterios.peso")) {
                pesos = criterio.getValue();
            }
        }

        if (nomes != null && descricoes != null && pmds != null && pesos != null) {
            for (int i = 0; i < nomes.length; i++) {
                Criterio novoCriterio = new Criterio();
                novoCriterio.setNome(nomes[i]);
                novoCriterio.setDescricao(descricoes[i]);
                novoCriterio.setPmd(PMD.valueOf(pmds[i]));
                novoCriterio.setPeso(Integer.parseInt(pesos[i]));
                criterios.add(novoCriterio);
            }
        }

        vaga.setCriterios(criterios);

        return vaga;
    }

}