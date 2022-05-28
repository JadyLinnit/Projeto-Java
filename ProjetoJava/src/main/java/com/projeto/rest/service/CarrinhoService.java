package com.projeto.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projeto.rest.entities.Carrinho;
import com.projeto.rest.entities.Produto;
import com.projeto.rest.repository.CarrinhoRepository;

@Component
@Service
public class CarrinhoService {
	@Autowired
	CarrinhoRepository repo;
	
	public List<Carrinho> listarCarrinho(){
		List<Carrinho> carrinho = repo.findAll();
		
		return carrinho;
	}
	
	public Carrinho salvar (Carrinho carrinho) {
		return repo.save(carrinho);
	}
	
	public Carrinho pegarCarrinho(int idcarrinho) {
		return repo.findById(idcarrinho).get();
	}
	
	public Carrinho alterar (int idcarrinho, Carrinho carrinho) {
		Carrinho car = repo.findById(idcarrinho).get();
		car.setProduto(carrinho.getProduto());
		car.setQuantidade(carrinho.getQuantidade());
		car.setVenda(carrinho.getVenda());
		car = repo.save(car);
		return (car);
	}
	
	public void excluir(int idcarrinho) {
		repo.deleteById(idcarrinho);
	}

}
