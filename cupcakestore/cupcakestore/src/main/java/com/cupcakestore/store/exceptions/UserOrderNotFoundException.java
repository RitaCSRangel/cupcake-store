package com.cupcakestore.store.exceptions;

// Classe UserOrderNotFoundException
// Responsável por definir um modelo de exceção para quando os Produtos não forem encontrados
public class UserOrderNotFoundException extends RuntimeException {

    // -------- Método Construtor --------
    // Construtor UserOrderNotFoundException
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado
    public UserOrderNotFoundException(String message) {
        super(message);
    }
}
