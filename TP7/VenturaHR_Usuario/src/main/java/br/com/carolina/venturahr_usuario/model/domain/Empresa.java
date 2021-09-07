package br.com.carolina.venturahr_usuario.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Empresa extends Usuario {
    @Column(unique=true, nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String razaoSocial;

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
