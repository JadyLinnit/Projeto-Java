package com.projeto.rest.service.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExcecaoById extends RuntimeException {
     private static final long serialVersionUID = 1L;
     
     public ExcecaoById(String mensagem) {
    	 super(mensagem);
     }
	
	

}
