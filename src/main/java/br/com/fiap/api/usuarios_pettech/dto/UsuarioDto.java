package br.com.fiap.api.usuarios_pettech.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
        long id,
        @NotBlank(message = "O nome é obrigatório e não pode estar em branco")
        String nome,

        @Email(message = "O email deve ser válido")
        String email,
        
        String cpf,
        LocalDate dataNascimento) {

}
