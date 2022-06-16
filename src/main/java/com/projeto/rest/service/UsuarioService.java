package com.projeto.rest.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.projeto.rest.dto.UsuarioDTO;
import com.projeto.rest.entities.Usuario;
import com.projeto.rest.entities.UsuarioLogin;
import com.projeto.rest.repository.UsuarioRepository;
import com.projeto.rest.service.excecao.ExcecaoById;
import com.projeto.rest.service.excecao.UsuarioOuSenhaInvalidaException;

@Component
@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repo;

	public List<UsuarioDTO> listarTodos() {
		List<Usuario> usuarios = repo.findAll();

		
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();

		for (Usuario user : usuarios) {
			usuariosDTO.add(new UsuarioDTO(user));
		}
		return usuariosDTO;
	}

	public UsuarioDTO salvar(Usuario usuario) {		
		Usuario user = repo.save(usuario);
		return new UsuarioDTO(user);
		
	}

	public UsuarioDTO pegarUsuario(int idusuario) {
		Usuario user = repo.findById(idusuario)
				.orElseThrow(() -> new ExcecaoById("Erro ao tentar resgatar Usuário de ID: " + idusuario));
		return new UsuarioDTO(user);
	}

	public UsuarioDTO alterar(int idusuario, Usuario usuario) {
		
		try {
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
		user.setComplemento(usuario.getComplemento());
		user.setPerfil(usuario.getPerfil());
		user = repo.save(user);
		return new UsuarioDTO(user);
		} catch (Exception e) {
			
			throw new ExcecaoById("Erro ao inserir Usuário de ID: " + idusuario);
		}
	}

	public void excluir(int idusuario) {
		try {
		repo.deleteById(idusuario);
		}
		catch (Exception e) {
			throw new ExcecaoById("Erro ao deletar Usuário de ID: " + idusuario );
		}
	}

	public UsuarioLogin logarUsuario(UsuarioLogin usuarioLogin)  {
					
		try {
			Optional<Usuario> usuario = repo.findByEmail(usuarioLogin.getEmail());

		//if (usuario.isPresent()) {
				usuarioLogin.setToken(generatorBasicToken(usuarioLogin.getEmail(), usuarioLogin.getSenha()));
				usuarioLogin.setId(usuario.get().getId());
				usuarioLogin.setNome(usuario.get().getNome());
				usuarioLogin.setEmail(usuario.get().getEmail());
				usuarioLogin.setSenha(usuario.get().getSenha());
				usuarioLogin.setCpf(usuario.get().getCpf());
				usuarioLogin.setPerfil(usuario.get().getPerfil());
				return usuarioLogin;
			//}
			}
			catch (Exception e) {
				throw new UsuarioOuSenhaInvalidaException( "Usuário ou senha inválidos!");
				
			}
		}
	
	/*private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(senha);
		return senhaEncoder;
	}*/
	
	/*private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		return encoder.matches(senhaDigitada, senhaBanco);
	}*/

	private String generatorBasicToken(String email, String password) {
		String structure = email + ":" + password;
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return new String(structureBase64);
	}

}