package com.cupcakestore.store.models;

import java.io.Serializable;

import org.hibernate.annotations.GenerationTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Classe UserOrder
// Essa classe é responsável por definir as características e funções de um objeto de Ordem/Pedido.
@Entity
// Essa anotação define que essa classe pode ser mapeada para dentro de uma
// tabela.
public class UserOrder implements Serializable {

	// -------- Atributos --------
	@Id // Essa notação define que o atributo id será um identificador único de cada
		// produto instanciado a partir dessa classe
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Essa anotação define que os valores do atributo id serão
														// gerados automaticamente
	@Column(nullable = false, updatable = false) // Essa anotação define que a colina de ids na tabela não pode ser
													// vazia e nem atualizada
	private Long id;

	private Long userId;
	private Float value;
	private String status;

	// -------- Método Construtor --------

	// Construtor UserOrder sem parâmetros
	// Lembrete: O método construtor define o estado/ação de um objeto dessa classe
	// assim que ele for instanciado. Quando o objeto for
	// instanciado sem que nenhum atributo seja passado como parâmetro então é esse
	// construtor que será chamado.
	public UserOrder() {
	}

	// Construtor UserOrder
	// Lembrete: O método construtor define o estado/ação de um objeto dessa classe
	// assim que ele for instanciado. Quando o objeto for
	// instanciado com atributo como parâmetro então é esse construtor que será
	// chamado.
	public UserOrder(
			Long userId,
			Float value,
			String status) {

		this.userId = userId;
		this.value = value;
		this.status = status;
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

	// userId
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// value
	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	// status
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
