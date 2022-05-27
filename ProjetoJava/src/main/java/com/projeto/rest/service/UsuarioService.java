package com.projeto.rest.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projeto.rest.dto.UsuarioDTO;
import com.projeto.rest.entities.Usuario;
import com.projeto.rest.repository.UsuarioRepository;



@Component
@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repo;
	
	public List<UsuarioDTO> listarTodos(){
		java.util.List<Usuario> usuarios = repo.findAll();
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
				
		for(Usuario user: usuarios) {
			usuariosDTO.add(new UsuarioDTO(user));
		}
		return usuariosDTO;
	}

	public UsuarioDTO salvar(Usuario usuario) {
		Usuario user = repo.save(usuario);
		return new UsuarioDTO(user);
	}
	
	public UsuarioDTO pegarUsuario(int idusuario) {
		  Usuario user = repo.findById(idusuario).get();
		  return new UsuarioDTO(user);
		}
		
		public UsuarioDTO alterar(int idusuario, Usuario usuario) {
			Usuario user = repo.findById(idusuario).get();
			user.setNome(usuario.getNome());
			user.setEmail(usuario.getEmail());
			user.setSenha(usuario.getSenha());
			user.setFone(usuario.getFone());
			user.setEstado(usuario.getEstado());
			user.setCidade(usuario.getCidade());
			user.setBairro(usuario.getBairro());
			user.setRua(usuario.getRua());
			user.setCep(usuario.getCep());
			user.setNumero(usuario.getNumero());
			user.setComplemento (usuario.getComplemento());
			user.setPerfil(usuario.getPerfil());
			user = repo.save(user);
			return new UsuarioDTO(user);
		}
		
		public void excluir(int idusuario) {
			repo.deleteById(idusuario);
		}
		
	}