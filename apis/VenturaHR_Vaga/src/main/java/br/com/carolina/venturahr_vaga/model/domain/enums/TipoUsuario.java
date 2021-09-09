package br.com.carolina.venturahr_vaga.model.domain.enums;

public enum TipoUsuario {
    ADMIN("admin"),
    EMPRESA("empresa"),
    CANDIDATO("candidato");

    private String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
