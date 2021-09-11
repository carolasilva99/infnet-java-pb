package br.com.carolina.venturahr_web.model.domain.enums;

public enum StatusVaga {
    ABERTA("ABERTA"),
    RESPONDIDA("RESPONDIDA"),
    EXPIRADA("EXPIRADA"),
    RENOVADA("RENOVADA"),
    FINALIZADA("FINALIZADA");

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

