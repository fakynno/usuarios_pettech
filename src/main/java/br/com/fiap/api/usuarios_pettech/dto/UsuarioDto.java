package br.com.fiap.api.usuarios_pettech.dto;

import java.time.LocalDate;

public record UsuarioDto(
        Long id,
        String nome,
        String email,
        String cpf,
        LocalDate dataNascimento) {

}
