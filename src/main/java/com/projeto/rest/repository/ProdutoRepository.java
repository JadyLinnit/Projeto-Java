package com.projeto.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.rest.entities.Produto;

	@Repository
	public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

		
	}

