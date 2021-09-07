package br.com.carolina.venturahr_usuario.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Administrador extends Usuario {
    @NotBlank(message = "É obrigatório informar o nome")
    @Column(nullable = false)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

