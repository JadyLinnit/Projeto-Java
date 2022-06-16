package com.projeto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.rest.entities.Categoria;
import com.projeto.rest.service.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaService service;
	
	@GetMapping
	public ResponseEntity<List<Categoria>>listarTodas(){
		return ResponseEntity.ok(service.listarTodas());
	}
	
	@GetMapping("/nome")
	public ResponseEntity<List<Categoria>> buscarNome(@RequestParam("nome") String nome){
		return ResponseEntity.ok(service.buscarNome(nome));
	}	
}

	
