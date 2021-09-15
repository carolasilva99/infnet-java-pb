package br.com.carolina.venturahr_web.model.domain;

import br.com.carolina.venturahr_web.model.domain.enums.PMD;

public class Criterio {
    private int id;
    private String nome;
    private String descricao;
    private PMD pmd;
    private int peso;
    private Vaga vaga;

    public Criterio(String descricaoCriterio) {
        setDescricao(descricaoCriterio);
    }

    public Criterio() {
    }

    public Criterio(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PMD getPmd() {
        return pmd;
    }

    public void setPmd(PMD pmd) {
        this.pmd = pmd;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
