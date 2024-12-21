package br.com.fiap.api.usuarios_pettech.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fiap.api.usuarios_pettech.errors.StandardErrorResponse;
import br.com.fiap.api.usuarios_pettech.errors.ValidateError;
import br.com.fiap.api.usuarios_pettech.exceptions.ControllerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private StandardErrorResponse error = new StandardErrorResponse();

    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> entityNotFound(ControllerNotFoundException e, HttpServletRequest request) {

            HttpStatus status = HttpStatus.NOT_FOUND;
            error.setTimestamp(Instant.now());
            error.setStatus(status.value());
            error.setError("Entity not found");
            error.setMessage(e.getMessage());
            error.setPath(request.getRequestURI());

            return ResponseEntity.status(status).body(error);
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorResponse> validationErrors(MethodArgumentNotValidException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidateError validateError = new ValidateError();

        validateError.setTimestamp(Instant.now());
        validateError.setStatus(status.value());
        validateError.setError("Erro de validacao");
        validateError.setMessage(e.getMessage());
        validateError.setPath(request.getRequestURI());

        for (FieldError f: e.getBindingResult().getFieldErrors()) {
            validateError.addMensagens(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(validateError);
    }


}
