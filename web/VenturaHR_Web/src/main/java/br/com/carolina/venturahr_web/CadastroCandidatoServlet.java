package br.com.carolina.venturahr_web;

import br.com.carolina.venturahr_web.model.domain.Candidato;
import br.com.carolina.venturahr_web.model.domain.Usuario;
import br.com.carolina.venturahr_web.model.error.CadastroCandidatoException;
import br.com.carolina.venturahr_web.model.error.ErroNaAutenticacaoException;
import br.com.carolina.venturahr_web.model.service.CadastroCandidatoService;
import br.com.carolina.venturahr_web.model.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CadastroCandidatoServlet", value = "/cadastro-candidato")
public class CadastroCandidatoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidato candidato = criarCandidatoAPartirDaRequisicao(req);
        CadastroCandidatoService cadastroCandidatoService = new CadastroCandidatoService();

        try {
            cadastroCandidatoService.cadastro(candidato);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch(CadastroCandidatoException ex) {
            req.setAttribute("mensagem_erro", ex.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }

    private Candidato criarCandidatoAPartirDaRequisicao(HttpServletRequest req) {
        Candidato candidato = new Candidato();
        candidato.setCpf(req.getParameter("cpf"));
        candidato.setNome(req.getParameter("nome"));
        candidato.setEmail(req.getParameter("email"));
        candidato.setSenha(req.getParameter("senha"));
        candidato.setEndereco(req.getParameter("endereco"));
        candidato.setTelefone(req.getParameter("telefone"));
        return candidato;
    }

    public void destroy() {
    }
}