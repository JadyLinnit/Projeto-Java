package com.projeto.rest.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.rest.service.execao.ExecaoById;
import com.projeto.rest.service.execao.UsuarioOuSenhaInvalidaExeption;

@ControllerAdvice
public class ControllerAdviceException {
	
	@ExceptionHandler({ExecaoById.class,UsuarioOuSenhaInvalidaExeption.class})
	public ResponseEntity<Problema> erros( ExecaoById pro , HttpServletRequest http){
		Problema problema = new Problema((long) HttpStatus.NOT_FOUND.value(),
				Instant.now(),pro.getMessage(),http.getRequestURI());
		          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
	}

}
