package com.cupcakestore.store.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Classe Product
// Essa classe é responsável por definir as características e funções de um objeto Produto.
@Entity
// Essa anotação define que essa classe pode ser mapeada para dentro de uma
// tabela.
public class Product implements Serializable {

	// -------- Atributos --------
	@Id // Essa notação define que o atributo id será um identificador único de cada
		// produto instanciado a partir dessa classe
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Essa anotação define que os valores do atributo id serão
														// gerados automaticamente
	@Column(nullable = false, updatable = false) // Essa anotação define que a colina de ids na tabela não pode ser
													// vazia e nem atualizada
	private Long id;

	private String name;
	private Float value;
	private String type;
	private Integer quantity;
	private Integer stock;
	private Float score;
	private String image;

	// -------- Método Construtor --------

	// Construtor Product sem parâmetros
	// Lembrete: O método construtor define o estado/ação de um objeto dessa classe
	// assim que ele for instanciado. Quando o objeto for
	// instanciado sem que nenhum atributo seja passado como parâmetro então é esse
	// construtor que será chamado.
	public Product() {
	}

	// Construtor Product
	// Lembrete: O método construtor define o estado/ação de um objeto dessa classe
	// assim que ele for instanciado. Quando o objeto for
	// instanciado com atributo como parâmetro então é esse construtor que será
	// chamado.
	public Product(
			String name,
			Float value,
			String type,
			Integer quantity,
			Integer stock,
			Float score,
			String image) {

		this.name = name;
		this.value = value;
		this.type = type;
		this.quantity = quantity;
		this.stock = stock;
		this.score = score;
		this.image = image;
	}

	// -------- Métodos Getters e Setters --------
	// Lembrete: Os atributos de uma classe podem ser acessados ou definidos somente
	// através dos métodos getters e setters respectivamente.
	// Cada atributo tem o seu próprio get e set.

	// id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// value
	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	// type
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// quantity
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	// stock
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	// score
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	// image
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
