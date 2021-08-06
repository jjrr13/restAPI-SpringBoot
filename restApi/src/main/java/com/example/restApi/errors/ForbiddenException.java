package com.example.restApi.errors;

public class ForbiddenException extends RuntimeException{
    public  static final String DESCRIPCION = "Forbidden Exception (403)";

    public ForbiddenException(String message) {
        super(DESCRIPCION + ". " + message);
    }
}
