package br.com.rocha.rinha.backend.models.Exception;

public class UsuarioNaoEncontrado extends Exception {

    private final String message;

    public UsuarioNaoEncontrado(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "message='" + message + '\'' +
                '}';
    }
}
