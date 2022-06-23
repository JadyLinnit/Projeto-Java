package com.projeto.rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.projeto.rest.entities.Venda;
import com.projeto.rest.repository.VendaRepository;

@Service
public class VendaService {

    private VendaRepository vendaRepository;
    private ProdutoService produtoService;

    public VendaService(VendaRepository vendaRepository, ProdutoService produtoService) {
        this.vendaRepository = vendaRepository;
        this.produtoService = produtoService;
    }

    public Venda postVenda(Venda vendaToPost){
    	// Esse trecho vai iterar todos os produtos, setar o false e depois salvar
    	var produtosParaBaixar = vendaToPost.getCarrinho().stream()
                .map(prod -> prod.getProduto()).collect(Collectors.toList());

        produtoService.darBaixaProdutos(produtosParaBaixar);

        return vendaRepository.save(vendaToPost);
    }

    public List<Venda> getAllVendasByUsuario(Integer idUsuario){
        return vendaRepository.findVendasByIdUsuario(idUsuario);
    }

}