package com.projeto.rest.entities;

import javax.persistence.*;

@Entity
@Table(name="tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "disponivel")
	private boolean isDisponivel;

	@Column(name = "preco")
	private double preco;
	@Column(name = "foto")
	private String foto;
	@ManyToOne
	private Categoria categoria;

	public Produto(int id, String descricao, boolean isDisponivel, double preco, String foto, Categoria categoria) {
		this.id = id;
		this.descricao = descricao;
		this.isDisponivel = isDisponivel;
		this.preco = preco;
		this.foto = foto;
		this.categoria = categoria;
	}

	public Produto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isDisponivel() {
		return isDisponivel;
	}

	public void setDisponivel(boolean disponivel) {
		isDisponivel = disponivel;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Produto(int id, String descricao) {
		
		this.id = id;
		this.descricao = descricao;
	}

}