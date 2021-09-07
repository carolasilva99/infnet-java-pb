package br.com.carolina.venturahr_usuario.model.exception;

public class UsuarioNaoEncontrado extends RuntimeException {
    public UsuarioNaoEncontrado(String msg) {
        super(msg);
    }
}
