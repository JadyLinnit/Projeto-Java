package com.projeto.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.rest.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String>{
	public List<Categoria>findAllByNome(String nome);

}
