package br.com.carolina.venturahr_vaga.model.domain;

import br.com.carolina.venturahr_vaga.model.domain.enums.PMDCandidatura;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Proficiencia {
    @Id
    private int id;
    @ManyToOne
    private Criterio criterio;
    @Enumerated(EnumType.ORDINAL)
    private PMDCandidatura nota;
    @ManyToOne
    @JoinColumn(name = "candidatura_id")
    @JsonBackReference
    private Candidatura candidatura;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public PMDCandidatura getNota() {
        return nota;
    }

    public void setNota(PMDCandidatura nota) {
        this.nota = nota;
    }

    public Candidatura getCandidatura() {
        return candidatura;
    }

    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
    }
}
