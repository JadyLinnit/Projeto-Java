package com.projeto.rest.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tb_venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "data_compra")
	private String data;

	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name= "valor_total")
	private double valorTotal;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_carrinho", referencedColumnName = "id")
	private List<Carrinho> carrinho;

	public Venda(int id, String data, Integer idUsuario, double valorTotal, List<Carrinho> carrinho) {
		this.id = id;
		this.data = data;
		this.idUsuario = idUsuario;
		this.carrinho = carrinho;
		this.valorTotal= valorTotal;
	}
	
	public Venda() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Carrinho> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(List<Carrinho> carrinho) {
		this.carrinho = carrinho;
	}
}