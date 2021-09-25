package br.com.carolina.venturahr_web.model.error;

public class ErroApiException extends RuntimeException {
    public ErroApiException(String message) {
        super(message);
    }
}
