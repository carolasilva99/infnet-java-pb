package br.com.carolina.venturahr_candidatura.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Candidatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Candidato candidato;
    private LocalDateTime data;
    @ManyToOne
    private Vaga vaga;
    @OneToMany(mappedBy = "candidatura")
    @NotEmpty
    @JsonManagedReference
    private List<Proficiencia> proficiencias;
    private String observacao;
    private float nota;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public List<Proficiencia> getProficiencias() {
        return proficiencias;
    }

    public void setProficiencias(List<Proficiencia> proficiencias) {
        this.proficiencias = proficiencias;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
