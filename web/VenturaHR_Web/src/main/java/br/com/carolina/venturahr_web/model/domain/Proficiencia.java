package br.com.carolina.venturahr_web.model.domain;

import br.com.carolina.venturahr_web.model.domain.enums.PMDCandidatura;

public class Proficiencia {
    private int id;
    private Criterio criterio;
    private PMDCandidatura nota;
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
