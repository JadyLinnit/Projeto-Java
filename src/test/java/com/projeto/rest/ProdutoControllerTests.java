package com.projeto.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.projeto.rest.entities.Produto;
import com.projeto.rest.service.ProdutoService;


@SpringBootTest(classes = ProdutoControllerTests.class)
@AutoConfigureMockMvc
public class ProdutoControllerTests {

	private Integer idExistente;
	private Integer idInexistente;

	private Produto produtoExistente;
	private Produto produtoNovo;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProdutoService service;

	

	@BeforeEach
	void setup() {
		idExistente = 1;
		idInexistente = 2;

		produtoNovo = new Produto();
		produtoExistente = new Produto(idExistente, "Um homem recebe proposta para administrar um hotel misterioso");

		Mockito.when(service.pegarProduto(idExistente)).thenReturn(produtoExistente);
		Mockito.when(service.pegarProduto(idInexistente)).thenThrow(EntityNotFoundException.class);

	}

	//@Test
	void deveRetornarOkQuandoPegarProdutoIdExistente() throws Exception {
		ResultActions result = mockMvc
				.perform(get("/produto/{idproduto}", idExistente).accept(MediaType.APPLICATION_JSON));
		result.andExpect(status().isOk());
	}
	
	//@Test
	void deveRertornarStatus404QuandoPegarProdutoIdInexistente() throws Exception {
		ResultActions obj =	mockMvc.perform(get("/produto/{idproduto}", idInexistente)
			                           .accept(MediaType.APPLICATION_JSON));
		
		    obj.andExpect(status().isNotFound());		    
	}
	
	

}
