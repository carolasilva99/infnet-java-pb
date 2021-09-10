package br.com.carolina.venturahr_usuario.model.domain.enums;

import br.com.carolina.venturahr_usuario.model.exception.StatusNaoEncontradoException;

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

    public static StatusUsuario from(String status) {
        try {
            return StatusUsuario.valueOf(status);
        }
        catch(IllegalArgumentException exception) {
            throw new StatusNaoEncontradoException("O status " + status + " não existe");
        }
    }
}
