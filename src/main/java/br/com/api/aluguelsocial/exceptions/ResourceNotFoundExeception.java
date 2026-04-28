package br.com.api.aluguelsocial.exceptions;

public class ResourceNotFoundExeception extends RuntimeException {
    public ResourceNotFoundExeception(String message) {
        super(message);
    }
}
