package br.com.carolina.venturahr_candidatura.model.domain;

import br.com.carolina.venturahr_candidatura.model.domain.enums.StatusVaga;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Vaga {
    @Id
    private int id;
    @OneToOne
    private Empresa empresa;
    @NotEmpty
    private String cargo;
    @OneToMany(mappedBy = "vaga")
    @NotEmpty
    @JsonManagedReference
    private List<Criterio> criterios;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusVaga status;
    private LocalDateTime dataInicio;

    public Vaga() {
    }

    public Vaga(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<Criterio> criterios) {
        this.criterios = criterios;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public void setStatus(StatusVaga status) {
        this.status = status;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }
}
