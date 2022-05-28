package com.projeto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projeto.rest.entities.Produto;
import com.projeto.rest.repository.ProdutoRepository;

@Component
@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository repo;
	
	public List<Produto> listarProdutos(){
		List<Produto> produto = repo.findAll();
		
		return produto;		
	}
	
	public Produto salvar (Produto produto) {
		return repo.save(produto);
	}
	
	public Produto pegarProduto(int idproduto) {
		return repo.findById(idproduto).get();
	}
	
	public Produto alterar (int idproduto, Produto produto) {
		Produto prod = repo.findById(idproduto).get();
		prod.setDescricao(produto.getDescricao());
		prod.setEstoque(produto.getEstoque());
		prod.setCategoria(produto.getCategoria());
		prod.setFoto(produto.getFoto());
		prod.setPreco(produto.getPreco());
		prod = repo.save(prod);
		return (prod);
	}
	
	public void excluir(int idproduto) {
		repo.deleteById(idproduto);
	}
}
