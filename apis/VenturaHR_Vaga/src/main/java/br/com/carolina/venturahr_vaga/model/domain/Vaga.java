package br.com.carolina.venturahr_vaga.model.domain;

import br.com.carolina.venturahr_vaga.model.domain.enums.StatusVaga;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Empresa empresa;
    @NotEmpty
    @Column(nullable = false)
    private String cargo;
    @OneToMany(mappedBy = "vaga")
    @NotEmpty
    @JsonManagedReference
    private List<Criterio> criterios;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusVaga status;
    private LocalDateTime dataInicio;
    private Float pmd;

    public Vaga(Integer idVaga) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Float getPmd() {
        return pmd;
    }

    public void setPmd(Float pmd) {
        this.pmd = pmd;
    }
}
