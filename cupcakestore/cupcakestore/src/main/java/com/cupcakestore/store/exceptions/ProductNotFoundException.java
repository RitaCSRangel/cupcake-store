package com.cupcakestore.store.exceptions;

// Classe ProductNotFoundException
// Responsável por definir um modelo de exceção para quando os Produtos não forem encontrados
public class ProductNotFoundException extends RuntimeException {

    // -------- Método Construtor --------
    // Construtor ProductNotFoundException
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado
    public ProductNotFoundException(String message) {
        super(message);
    }
}
