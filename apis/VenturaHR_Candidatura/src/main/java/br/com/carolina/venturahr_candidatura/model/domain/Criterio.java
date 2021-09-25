package br.com.carolina.venturahr_candidatura.model.domain;

import br.com.carolina.venturahr_candidatura.model.domain.enums.PMD;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Criterio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private PMD pmd;
    @ManyToOne
    @JoinColumn(name="vaga_id")
    @JsonBackReference
    private Vaga vaga;
    private int peso;

    public Criterio(String descricaoCriterio) {
        setDescricao(descricaoCriterio);
    }

    public Criterio() {
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
