package br.com.carolina.venturahr_candidatura.model.domain;

import javax.persistence.Entity;

@Entity
public class Candidato extends Usuario {
    private String cpf;
    private String nome;

    public Candidato() {
    }

    public Candidato(int idCandidato) {
        setId(idCandidato);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
