package br.com.carolina.venturahr_web.model.domain;

import br.com.carolina.venturahr_web.model.domain.enums.StatusVaga;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vaga {
    private int id;
    private Empresa empresa;
    private String cargo;
    private List<Criterio> criterios;
    private StatusVaga status;
    private String dataInicio;
    private float pmd;

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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public float getPmd() {
        return pmd;
    }

    public void setPmd(float pmd) {
        this.pmd = pmd;
    }
}
