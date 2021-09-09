package br.com.carolina.venturahr_autenticacao.model.exception;

public class UsuarioOuSenhaInvalidosException extends RuntimeException {
    public UsuarioOuSenhaInvalidosException(String msg) {
        super(msg);
    }
}
