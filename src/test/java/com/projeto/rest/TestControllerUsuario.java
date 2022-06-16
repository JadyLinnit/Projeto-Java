package com.projeto.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.persistence.EntityNotFoundException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.rest.dto.UsuarioDTO;
import com.projeto.rest.entities.Usuario;
import com.projeto.rest.service.UsuarioService;


@SpringBootTest(classes = TestControllerUsuario.class)
@AutoConfigureMockMvc
public class TestControllerUsuario {

	private Integer idExistente;
    private Integer idInexistente;
    private Usuario usuario;
    private List<Usuario> users;
    private Usuario usuarioExistente;
    private UsuarioDTO existeUsuario;
    
    
    @Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsuarioService service;
	
	
	
	@BeforeEach
	void setup() {
		idExistente = 1;
		idInexistente = 100;
		//usuarioNovo = new Usuario();
		usuarioExistente = new Usuario(idExistente, "Renata Floro");
		Mockito.when(service.pegarUsuario(idExistente)).thenReturn(existeUsuario);
		Mockito.when(service.pegarUsuario(idInexistente)).thenThrow(EntityNotFoundException.class);
		Mockito.when(service.salvar(any())).thenReturn(existeUsuario);
		Mockito.when(service.alterar(eq(idExistente), any())).thenReturn(existeUsuario);
		Mockito.when(service.alterar(eq(idInexistente), any())).thenThrow(EntityNotFoundException.class);
		
}
	
	//@Test
    void deveRetornarOkQuandoPegarUsuarioIdExistente() throws Exception {
	    ResultActions result =	mockMvc.perform(get("/usuario/{idusuario}", idExistente)
		       .accept(MediaType.APPLICATION_JSON));
	    result.andExpect(status().isOk());
	}
	
	//@Test
	void deveRertornarStatus404QuandoPegarUsuarioIdInexistente() throws Exception {
		ResultActions obj =	mockMvc.perform(get("/usuario/{idusuario}", idInexistente)
			                           .accept(MediaType.APPLICATION_JSON));
		
		    obj.andExpect(status().isNotFound());		    
	}
	
	
}
