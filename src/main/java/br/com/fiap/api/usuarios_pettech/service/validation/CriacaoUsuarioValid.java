package br.com.fiap.api.usuarios_pettech.service.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CriacaoUsuarioValidator.class)
public @interface CriacaoUsuarioValid {

    String message() default "Erro de validacao";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
