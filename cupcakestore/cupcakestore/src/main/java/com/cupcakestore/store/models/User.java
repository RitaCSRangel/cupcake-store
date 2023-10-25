package com.cupcakestore.store.models;

import java.io.Serializable;

import org.hibernate.mapping.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Classe User
// Essa classe é responsável por definir as características e funções de um objeto Produto.
@Entity
// Essa anotação define que essa classe pode ser mapeada para dentro de uma
// tabela.
public class User implements Serializable {

    // -------- Atributos --------
    @Id // Essa notação define que o atributo id será um identificador único de cada
        // produto instanciado a partir dessa classe
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Essa anotação define que os valores do atributo id serão
                                                        // gerados automaticamente
    @Column(nullable = false, updatable = false) // Essa anotação define que a colina de ids na tabela não pode ser
                                                 // vazia e nem atualizada
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String password;
    private Boolean admin;

    // -------- Método Construtor --------

    // Construtor User sem parâmetros
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Quando o objeto for
    // instanciado sem que nenhum atributo seja passado como parâmetro então é esse
    // construtor que será chamado.
    public User() {
    }

    // Construtor User
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado. Quando o objeto for
    // instanciado com atributo como parâmetro então é esse construtor que será
    // chamado.
    public User(
            String name,
            String email,
            String phone,
            String rua,
            String numero,
            String bairro,
            String cidade,
            String estado,
            String cep,
            String password,
            Boolean admin) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.password = password;
        this.admin = admin;
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

    // email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // rua
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    // numero
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // bairro
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    // cidade
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // estado
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // cep
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    // password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // admin
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}