package com.projeto.rest.service.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UsuarioOuSenhaInvalidaException extends RuntimeException {
      private static final long serialVersionUID = 1L;
      
      public UsuarioOuSenhaInvalidaException(String mensagem) {
    	  super(mensagem);
      }
      

}
