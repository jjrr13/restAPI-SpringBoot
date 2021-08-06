package com.example.restApi.errors;

public class BadRequestException extends RuntimeException{

    public  static final String DESCRIPCION = "Bad Request Exception (400)";

    public BadRequestException(String message) {
        super(DESCRIPCION + ". " + message);
    }
}
