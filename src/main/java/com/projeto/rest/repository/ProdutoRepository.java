package com.projeto.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projeto.rest.entities.Produto;

import java.util.List;

@Repository
	public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
		@Query("select p from Produto p where p.disponivel = true")
		List<Produto> getAllDisponiveis();
	}