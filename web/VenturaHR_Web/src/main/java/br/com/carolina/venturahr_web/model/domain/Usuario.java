package br.com.carolina.venturahr_web.model.domain;

import br.com.carolina.venturahr_web.model.domain.enums.StatusUsuario;
import br.com.carolina.venturahr_web.model.domain.enums.TipoUsuario;

public class Usuario {
    private int id;
    private String email;
    private String endereco;
    private String senha;
    private String telefone;
    private StatusUsuario status;
    private TipoUsuario tipo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public StatusUsuario getStatus() {
        return status;
    }

    public void setStatus(StatusUsuario status) {
        this.status = status;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
