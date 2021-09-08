package br.com.carolina.venturahr_web.model.domain.enums;

public enum StatusUsuario {
    BLOQUEADO("bloqueado"),
    DESBLOQUEADO("desbloqueado");

    private String descricao;

    StatusUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
