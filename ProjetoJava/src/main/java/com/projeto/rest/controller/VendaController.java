package com.projeto.rest.controller;

import com.projeto.rest.entities.Venda;
import com.projeto.rest.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    private VendaService vendaService;

    
    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<Venda> postVenda(@RequestBody Venda venda){
        return ResponseEntity.ok(vendaService.postVenda(venda));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<Venda>> getAllVendasByUsuario(@PathVariable("idUsuario") Integer userId){
        return ResponseEntity.ok(vendaService.getAllVendasByUsuario(userId));
    }

}
