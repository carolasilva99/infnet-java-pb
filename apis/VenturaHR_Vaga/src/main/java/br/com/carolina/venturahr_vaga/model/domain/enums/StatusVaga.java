package br.com.carolina.venturahr_vaga.model.domain.enums;

public enum StatusVaga {
    ABERTA("aberta"),
    RESPONDIDA("respondida"),
    EXPIRADA("expirada"),
    RENOVADA("renovada"),
    FINALIZADA("finalizada");

    private String descricao;

    StatusVaga(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusVaga from (String status) {
        try {
            return StatusVaga.valueOf(status);
        }
        catch (Exception ex) {
            return null;
        }
    }
}

