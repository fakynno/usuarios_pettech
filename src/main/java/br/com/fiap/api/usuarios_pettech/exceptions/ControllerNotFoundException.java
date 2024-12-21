package br.com.fiap.api.usuarios_pettech.exceptions;

public class ControllerNotFoundException extends RuntimeException{
    
    public ControllerNotFoundException(String message) {
        super(message);
    }    

}
