package br.com.fiap.api.usuarios_pettech.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import br.com.fiap.api.usuarios_pettech.service.validation.CriacaoUsuarioValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@CriacaoUsuarioValid
public record UsuarioDto(
        long id,
        @NotBlank(message = "O nome é obrigatório e não pode estar em branco")
        String nome,

        @Email(message = "O email deve ser válido")
        @NotBlank(message = "O email é obrigatório e não pode estar em branco")
        String email,
        
        @CPF(message = "O CPF deve ser válido")
        @NotBlank(message = "O CPF é obrigatório e não pode estar em branco")
        String cpf,

        LocalDate dataNascimento
        ) {
}
