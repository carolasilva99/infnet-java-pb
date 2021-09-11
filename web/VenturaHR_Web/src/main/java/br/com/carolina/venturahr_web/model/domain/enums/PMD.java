package br.com.carolina.venturahr_web.model.domain.enums;

public enum PMD {
    DESEJAVEL(1, "desejável"),
    DIFERENCIAL(2, "diferencial"),
    RELEVANTE(3, "relevante"),
    MUITO_RELEVANTE(4, "muito relevantge"),
    OBRIGATORIO(5, "obrigatório");

    private String descricao;
    private int valor;

    PMD(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
