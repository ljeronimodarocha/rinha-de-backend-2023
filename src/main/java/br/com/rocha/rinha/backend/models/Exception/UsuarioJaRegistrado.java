package br.com.rocha.rinha.backend.models.Exception;

import lombok.Getter;


@Getter
public class UsuarioJaRegistrado extends Exception {


    private final String message;

    public UsuarioJaRegistrado(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "message='" + message + '\'' +
                '}';
    }
}
