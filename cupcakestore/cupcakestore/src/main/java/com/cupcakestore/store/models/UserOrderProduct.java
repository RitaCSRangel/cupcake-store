package com.cupcakestore.store.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Classe OrderProduct
// Essa classe é responsável por definir as características e funções de um objeto de Produto do Pedido.
@Entity
// Essa anotação define que essa classe pode ser mapeada para dentro de uma
// tabela.
public class UserOrderProduct implements Serializable {

	// -------- Atributos --------
	@Id // Essa notação define que o atributo id será um identificador único de cada
		// produto instanciado a partir dessa classe
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Essa anotação define que os valores do atributo id serão
														// gerados automaticamente
	@Column(nullable = false, updatable = false) // Essa anotação define que a colina de ids na tabela não pode ser
													// vazia e nem atualizada
	private Long id;

	private Long orderId;
	private Integer quantity;
	private Long productId;
	private Float score;

	// -------- Método Construtor --------

	// Construtor UserOrderProduct sem parâmetros
	// Lembrete: O método construtor define o estado/ação de um objeto dessa classe
	// assim que ele for instanciado. Quando o objeto for
	// instanciado sem que nenhum atributo seja passado como parâmetro então é esse
	// construtor que será chamado.
	public UserOrderProduct() {
	}

	// Construtor UserOrderProduct
	// Lembrete: O método construtor define o estado/ação de um objeto dessa classe
	// assim que ele for instanciado. Quando o objeto for
	// instanciado com atributo como parâmetro então é esse construtor que será
	// chamado.
	public UserOrderProduct(
			Long orderId,
			Integer quantity,
			Long productId,
			Float score) {

		this.orderId = orderId;
		this.quantity = quantity;
		this.productId = productId;
		this.score = score;
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

	// orderId
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	// quantity
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	// productId
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	// score
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}
}
