package br.app.gestaotec.demo_park_api.exception;

import lombok.Getter;

@Getter
public class CodigoUniqueViolationException extends RuntimeException {

    private String recurso;
    private String codigo;

    public CodigoUniqueViolationException(String message) {
        super(message);
    }

    public CodigoUniqueViolationException(String recurso, String codigo) {
        this.codigo = codigo;
        this.recurso = recurso;
    }
}
