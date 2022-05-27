package com.projeto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projeto.rest.entities.Categoria;
import com.projeto.rest.repository.CategoriaRepository;

@Component
@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repo;
	
	public List<Categoria> listarTodas(){
		List<Categoria> categoria = repo.findAll();
		 return categoria;
				
	}

	public List<Categoria> buscarNome (String nome) {
	List<Categoria> categoria = repo.findAllByNome(nome);
		return categoria;
	}
	
		

}
