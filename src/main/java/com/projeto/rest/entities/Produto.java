package com.projeto.rest.entities;

import javax.persistence.*;

@Entity
@Table(name="tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "disponivel")
	private Boolean disponivel;
	@Column(name = "preco")
	private Double preco;
	@Column(name = "foto")
	private String foto;
	@ManyToOne
	private Categoria categoria;

	public Produto(Integer id, String descricao, Boolean disponivel, Double preco, String foto, Categoria categoria) {
		this.id = id;
		this.descricao = descricao;
		this.disponivel = disponivel;
		this.preco = preco;
		this.foto = foto;
		this.categoria = categoria;
	}

	public Produto() {
	
	}

	public Produto(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
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
}