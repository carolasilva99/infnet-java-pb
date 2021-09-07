package br.com.carolina.venturahr_usuario.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Candidato extends Usuario {
    @NotBlank(message = "É obrigatório informar o cpf")
    @Column(unique=true)
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
