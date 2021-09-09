package br.com.carolina.venturahr_vaga.model.domain;

import br.com.carolina.venturahr_vaga.model.domain.enums.PMD;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Criterio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private PMD pmd;
    @ManyToOne
    @JoinColumn(name="vaga_id")
    @JsonBackReference
    private Vaga vaga;

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
}
