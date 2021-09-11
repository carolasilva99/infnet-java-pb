package br.com.carolina.venturahr_vaga.model.domain.enums;

public enum PMDCandidatura {
    NENHUM(1, "nenhum"),
    POUCO(2, "pouco"),
    MEDIO(3, "medio"),
    RELEVANTE(4, "relevantge"),
    TODO(5, "todo");

    private int valor;
    private String descricao;

    PMDCandidatura(int nota, String descricao) {
        this.valor = nota;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
