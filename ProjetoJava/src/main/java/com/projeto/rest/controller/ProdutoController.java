package com.projeto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.rest.entities.Produto;
import com.projeto.rest.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos(){
		return ResponseEntity.ok(service.listarProdutos());
	}
	
	@GetMapping("/{idproduto}")
	public ResponseEntity<Produto> pegarProduto(@PathVariable("idproduto") int idproduto){
		return ResponseEntity.status(HttpStatus.OK).body(service.pegarProduto(idproduto));
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvar (@RequestBody Produto produto){
		Produto prod = service.salvar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(prod);
	}
	
	@PutMapping("/{idproduto}")
	public ResponseEntity<Produto> alterar(@PathVariable("idproduto") int idproduto, @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idproduto, produto));
		
	}
	
	@DeleteMapping("/{idproduto}")
	public ResponseEntity<Produto> excluir(@PathVariable("idproduto") int idproduto){
		     service.excluir(idproduto);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}
	
	

}
