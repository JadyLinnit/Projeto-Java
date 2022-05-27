package com.projeto.rest.dto;

import com.projeto.rest.entities.Usuario;

public class UsuarioDTO {
	
	private int id;
	private String nome;
	private String email;
	private String fone;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String cep;
	private String numero;
	private String complemento;
	private String perfil;
	
	
	public UsuarioDTO(int id,String nome, String email, String fone, String estado, String cidade, String bairro, String rua,
			String cep, String numero, String complemento, String perfil ) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.perfil = perfil;
	}
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.fone = usuario.getFone();
		this.estado = usuario.getEstado();
		this.cidade = usuario.getCidade();
		this.bairro = usuario.getBairro();
		this.rua = usuario.getRua();
		this.cep = usuario.getCep();
		this.numero = usuario.getNumero();
		this.complemento = usuario.getComplemento();
		this.perfil = usuario.getPerfil();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
	
}

	
