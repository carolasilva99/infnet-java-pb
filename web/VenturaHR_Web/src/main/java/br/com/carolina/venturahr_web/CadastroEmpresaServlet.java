package br.com.carolina.venturahr_web;

import br.com.carolina.venturahr_web.model.domain.Empresa;
import br.com.carolina.venturahr_web.model.error.ErroApiException;
import br.com.carolina.venturahr_web.model.service.CadastroEmpresaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CadastroEmpresaServlet", value = "/cadastro-empresa")
public class CadastroEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Empresa empresa = criarEmpresaAPartirDaRequisicao(req);
        CadastroEmpresaService cadastroEmpresaService = new CadastroEmpresaService();

        try {
            cadastroEmpresaService.cadastro(empresa);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(req, resp);
        }
        catch(ErroApiException ex) {
            req.setAttribute("mensagem_erro", ex.getMessage());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
            requestDispatcher.forward(req, resp);
        }
    }

    private Empresa criarEmpresaAPartirDaRequisicao(HttpServletRequest req) {
        Empresa empresa = new Empresa();
        empresa.setEmail(req.getParameter("email"));
        empresa.setSenha(req.getParameter("senha"));
        empresa.setEndereco(req.getParameter("endereco"));
        empresa.setTelefone(req.getParameter("telefone"));
        empresa.setCnpj(req.getParameter("cnpj"));
        empresa.setRazaoSocial(req.getParameter("razaoSocial"));
        return empresa;
    }

    public void destroy() {
    }
}