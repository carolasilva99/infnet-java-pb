package br.com.carolina.venturahr_candidatura.model.exception;

public class CandidaturaNaoEncontradaException extends RuntimeException {
    public CandidaturaNaoEncontradaException(String message) {
        super(message);
    }
}
