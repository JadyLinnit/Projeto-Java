package com.projeto.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.projeto.rest.entities.Produto;
import com.projeto.rest.repository.ProdutoRepository;
import com.projeto.rest.service.ProdutoService;
import com.projeto.rest.service.excecao.ExcecaoById;

@ExtendWith(SpringExtension.class)
public class ProdutoServiceTests {
		
	private Integer idExistente;
    private Integer idInexistente;
    private Produto produto;
    private List<Produto> produtos;
    
    @InjectMocks
    private ProdutoService service;
    
    @Mock
	ProdutoRepository repo;
    
    @BeforeEach
	void setup() {
		idExistente = 1;
		idInexistente = 100;
		produto = new Produto();
		produtos = new ArrayList<>();
		
		Mockito.when(repo.findById(idExistente)).thenReturn(Optional.of(produto));
		Mockito.when(repo.findAll()).thenReturn(produtos);
		Mockito.doThrow(EntityNotFoundException.class).when(repo).findById(idInexistente);
		Mockito.doNothing().when(repo).deleteById(idExistente);
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repo).deleteById(idInexistente);
		Mockito.when(repo.save(produto)).thenReturn(produto);
		Mockito.doThrow(IllegalArgumentException.class).when(repo).save(produto);
    }
    
    @Test
	void returnNotNullQuandoConsultaPorIdExistente() {
		Produto prod = service.pegarProduto(idExistente);
		Assertions.assertNotNull(prod);
		Mockito.verify(repo).findById(idExistente);
	}
    
    @Test
	void naoExecutaQuandoDeletaIdExistente() {
		Assertions.assertDoesNotThrow(() -> {
			service.excluir(idExistente);
		});
	   Mockito.verify(repo, Mockito.times(1)).deleteById(idExistente);	
	}
    
    
    @Test
	void lancaExcecaoByIdQuandoIdInexistente() {
		Assertions.assertThrows(ExcecaoById.class, () -> {
			service.pegarProduto(idInexistente);
		});
		Mockito.verify(repo).findById(idInexistente);
	}

    
    @Test
	void lancarErroQuandoFaltamDados() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.salvar(produto);
		});
		Mockito.verify(repo).save(produto);
	}
   
    @Test
	void retornaNaoNullQuandoListaTodosProdutos() {
		List<Produto> produtos = service.listarProdutos();
		Assertions.assertNotNull(produtos);
	}
    
    void lancaErroAoAlteraProdutoComIdInexistente() {
		Produto prod = service.alterar(idInexistente, produto);
		Assertions.assertNotEquals(prod, produto);
		Mockito.verify(repo).save(produto);
	}
    
  
}
