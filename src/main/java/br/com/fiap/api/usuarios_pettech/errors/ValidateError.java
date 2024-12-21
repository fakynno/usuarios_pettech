package br.com.fiap.api.usuarios_pettech.errors;

import java.util.ArrayList;
import java.util.List;

public class ValidateError extends StandardErrorResponse {

    private List<ValidateMessageResponse> mensagens = new ArrayList<ValidateMessageResponse>();

    public List<ValidateMessageResponse> getMensagens() {
        return mensagens;
    }

    public void addMensagens(String campo, String mensagem) {
        mensagens.add(new ValidateMessageResponse(campo, mensagem));
    }    

}
