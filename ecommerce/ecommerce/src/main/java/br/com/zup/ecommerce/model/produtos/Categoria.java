package br.com.zup.ecommerce.model.produtos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_mae")
	private Categoria vinculoCategoria;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "produto_id") private Produto produto;
	 */

	public Categoria() {
	}

	public Categoria(String nome, Categoria vinculoCategoria) {
		this.nome = nome;
		this.vinculoCategoria = vinculoCategoria;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getVinculoCategoria() {
		return vinculoCategoria;
	}
	
	public Produto getProduto() {
		return produto;
	}

}
