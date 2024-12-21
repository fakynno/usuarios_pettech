package br.com.fiap.api.usuarios_pettech.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateMessageResponse {

    private String campo;
    private String mensagemDeErro;

}
