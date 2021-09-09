package br.com.carolina.venturahr_vaga.model.domain;

import br.com.carolina.venturahr_vaga.model.domain.enums.StatusUsuario;
import br.com.carolina.venturahr_vaga.model.domain.enums.TipoUsuario;

import javax.persistence.*;

@Entity
public abstract class Usuario {
    @Id
    private Integer id;
    private String email;
    private String endereco;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
