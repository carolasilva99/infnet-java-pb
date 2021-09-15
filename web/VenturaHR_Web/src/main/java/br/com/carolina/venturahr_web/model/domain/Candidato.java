package br.com.carolina.venturahr_web.model.domain;

public class Candidato extends Usuario {
    private String cpf;
    private String nome;

    public Candidato() {
    }

    public Candidato(int id) {
        setId(id);
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
