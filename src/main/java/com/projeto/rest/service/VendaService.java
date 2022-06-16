package com.projeto.rest.service;

import com.projeto.rest.entities.Venda;
import com.projeto.rest.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    private VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Venda postVenda(Venda vendaToPost){
        return vendaRepository.save(vendaToPost);
    }

    public List<Venda> getAllVendasByUsuario(Integer idUsuario){
        return vendaRepository.findVendasByIdUsuario(idUsuario);
    }

}
