package com.projeto.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.rest.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

    List<Venda> findVendasByIdUsuario(Integer idUsuario);

}
