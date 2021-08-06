package com.example.restApi.errors;

public class NotFoundException extends RuntimeException{

    public  static final String DESCRIPCION = "Page don't found (404)";

    public NotFoundException(String message) {
        super(DESCRIPCION + ". " + message);
    }
}
