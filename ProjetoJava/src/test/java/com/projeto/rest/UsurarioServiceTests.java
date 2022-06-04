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

import com.projeto.rest.dto.UsuarioDTO;
import com.projeto.rest.entities.Usuario;
import com.projeto.rest.repository.UsuarioRepository;
import com.projeto.rest.service.UsuarioService;
import com.projeto.rest.service.excecao.ExcecaoById;

@ExtendWith(SpringExtension.class)
public class UsurarioServiceTests {
	
	private Integer idExistente;
    private Integer idInexistente;
    private Usuario usuario;
    private List<Usuario> users;
    
    
    @InjectMocks
	private UsuarioService service;
	
	@Mock
	private UsuarioRepository repo;
	
	
	@BeforeEach
	void setup() {
		idExistente = 1;
		idInexistente = 100;
		usuario = new Usuario();
		users = new ArrayList<>();
		
		Mockito.when(repo.findById(idExistente)).thenReturn(Optional.of(usuario));
		Mockito.when(repo.findAll()).thenReturn(users);
		Mockito.doThrow(EntityNotFoundException.class).when(repo).findById(idInexistente);
		Mockito.doNothing().when(repo).deleteById(idExistente);
		Mockito.doThrow(EmptyResultDataAccessException.class).when(repo).deleteById(idInexistente);
		Mockito.when(repo.save(usuario)).thenReturn(usuario);
		Mockito.doThrow(IllegalArgumentException.class).when(repo).save(usuario);
	}		
	
	
	@Test
	void retornaNaoNuloQuandoConsultaPorIdExistente() {
		UsuarioDTO user = service.pegarUsuario(idExistente);
		Assertions.assertNotNull(user);
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
		Assertions.assertThrows(EntityNotFoundException.class, () -> {
			service.pegarUsuario(idInexistente);
		});
		Mockito.verify(repo).findById(idInexistente);
	}
	
	@Test
	void levantaExcecaoByIdQuandoDeleteIdInexistente() {
		Assertions.assertThrows(ExcecaoById.class, () ->{
			service.excluir(idInexistente);
		});
		Mockito.verify(repo, Mockito.times(1)).deleteById(idInexistente);		
	}
	
	
	@Test
	void lancarErroQuandoFaltamDados() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.salvar(usuario);
		});
		Mockito.verify(repo).save(usuario);
	}
	
	
	@Test
	void retornaNaoNullQuandoListaTodos() {
		List<UsuarioDTO> users = service.listarTodos();
		Assertions.assertNotNull(users);
	}

	void lancaErroAoAlteraContatoComIdInexistente() {
		UsuarioDTO u = service.alterar(idInexistente, usuario);
		Assertions.assertNotEquals(u, usuario);
		Mockito.verify(repo).save(usuario);
	}
	
	/*
	@Test
	void retornaContatoQuandoSalvaComSucesso() {
		UsuarioDTO u = service.salvar(usuario);
		Assertions.assertEquals(u, usuario);
		Mockito.verify(repo).save(usuario);		
	}
	
	@Test
	void retornaUsuarioQuandoAlteradoComSucesso() {
		UsuarioDTO u = service.alterar(idExistente, usuario);
		Assertions.assertEquals(u, usuario);
		Mockito.verify(repo).save(usuario);
	}
	*/
	
	
	
}
