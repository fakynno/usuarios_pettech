package br.com.fiap.api.usuarios_pettech.service.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.api.usuarios_pettech.dto.UsuarioDto;
import br.com.fiap.api.usuarios_pettech.repository.UsuarioRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CriacaoUsuarioValidator implements ConstraintValidator<CriacaoUsuarioValid, UsuarioDto>{

    @Autowired
    private UsuarioRepository repository;    

    @Override
    public void initialize(CriacaoUsuarioValid annotation) {}

    @Override
    public boolean isValid(UsuarioDto dto, ConstraintValidatorContext context) {
        Optional<UsuarioDto> usuario = repository.findByEmail(dto.email());
        return usuario.isEmpty();
    }

}
