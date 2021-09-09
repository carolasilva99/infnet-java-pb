package br.com.carolina.venturahr_vaga.model.domain.enums;

public enum PMD {
    DESEJAVEL("desejável"),
    DIFERENCIAL("diferencial"),
    RELEVANTE("relevante"),
    MUITO_RELEVANTE("muito relevantge"),
    OBRIGATORIO("obrigatório");

    private String descricao;

    PMD(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
