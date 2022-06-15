package com.projeto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projeto.rest.entities.Produto;
import com.projeto.rest.repository.ProdutoRepository;
import com.projeto.rest.service.excecao.ExcecaoById;

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
		try {
		return repo.findById(idproduto).get();
		}
		catch (Exception e) {
			throw new ExcecaoById("Erro ao tentar resgatar produto de ID: "+ idproduto );
		}
	}
	
	public Produto alterar (int idproduto, Produto produto) {
		try {
		Produto prod = repo.findById(idproduto).get();
		prod.setDescricao(produto.getDescricao());
		prod.setDisponivel(produto.isDisponivel());
		prod.setCategoria(produto.getCategoria());
		prod.setFoto(produto.getFoto());
		prod.setPreco(produto.getPreco());
		prod = repo.save(prod);
		return (prod);
		}
		catch (Exception e) {
			throw new  ExcecaoById("Erro ao alterar o produto de  ID: "+ idproduto + " PRODUTO NÃO EXISTENTE ");
		}
	}
	
	public void excluir(int idproduto) {
		try {
		repo.deleteById(idproduto);
		}
		catch (Exception e) {
			throw new ExcecaoById("Erro ao tentar excluir produto de ID: "+ idproduto );
		
		}
	}
	
	
	
}
