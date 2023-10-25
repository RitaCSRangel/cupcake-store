package com.cupcakestore.store.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product implements Serializable{

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

    private String name;
    private Integer value;
    private String type;
    private Integer quantity;
    private Integer stock;
    private Integer score;
    private String image;

	// Default Constructor
	public Product() {}

	// Constructor With Parameters
	public Product(
		String name,
		Integer value,
		String type,
		Integer quantity,
		Integer stock,
		Integer score,
		String image) {
		
		this.name = name;
		this.value = value;
		this.type = type;
		this.quantity = quantity;
		this.stock = stock;
		this.score = score;
		this.image = image;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Integer getValue(){
		return value;
	}

	public void setValue(Integer value){
		this.value = value;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public Integer getQuantity(){
		return quantity;
	}

	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}

	public Integer getStock(){
		return stock;
	}

	public void setStock(Integer stock){
		this.stock = stock;
	}

	public Integer getScore(){
		return score;
	}

	public void setScore(Integer score){
		this.score = score;
	}

	public String getImage(){
		return image;
	}

	public void setImage(String image){
		this.image = image;
	}

	@Override
	public String toString(){
		return "Products{" + 
				"id=" + id + 
				", name='" + name + '\'' + 
				", value='" + value + '\'' + 
				", type='" + type + '\'' + 
				", quantity='" + quantity + '\'' + 
				", stock='" + stock + '\'' + 
				", score='" + score + '\'' + 
				", image='" + image + '\'' + 
				+ '}';
	}
}
