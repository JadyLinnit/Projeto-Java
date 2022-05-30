package com.projeto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.rest.dto.UsuarioDTO;
import com.projeto.rest.entities.Usuario;
import com.projeto.rest.entities.UsuarioLogin;
import com.projeto.rest.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody UsuarioLogin user) {
		UsuarioLogin obj = service.logarUsuario(user);
		return ResponseEntity.ok(obj);

	}

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listaUsuarios() {
		return ResponseEntity.ok(service.listarTodos());
	}

	@GetMapping("/{idusuario}")
	public ResponseEntity<UsuarioDTO> pegarUsuario(@PathVariable("idusuario") int idusuario) {
		UsuarioDTO userDTO = service.pegarUsuario(idusuario);
		return ResponseEntity.ok().body(userDTO);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario usuario) {
		UsuarioDTO user = service.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@PutMapping("/{idusuario}")
	public ResponseEntity<UsuarioDTO> alterar(@PathVariable("idusuario") int idusuario, @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idusuario, usuario));

	}

	@DeleteMapping("/{idusuario}")
	public ResponseEntity<UsuarioDTO> excluir(@PathVariable("idusuario") int idusuario) {
		service.excluir(idusuario);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

}
