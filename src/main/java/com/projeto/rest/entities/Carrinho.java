package com.projeto.rest.entities;

import javax.persistence.*;

@Entity
@Table(name="tb_carrinho")
public class Carrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;

	public Carrinho(int id, Produto produto) {
		this.id = id;
		this.produto = produto;
	}

	public Carrinho() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
