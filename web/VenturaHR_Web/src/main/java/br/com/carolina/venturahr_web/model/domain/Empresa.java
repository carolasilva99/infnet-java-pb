package br.com.carolina.venturahr_web.model.domain;

public class Empresa extends Usuario {
    private String cnpj;
    private String razaoSocial;

    public Empresa() {
    }

    public Empresa(int empresaId) {
        setId(empresaId);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
