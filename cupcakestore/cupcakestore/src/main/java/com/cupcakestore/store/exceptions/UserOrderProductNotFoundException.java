package com.cupcakestore.store.exceptions;

// Classe UserOrderProductNotFoundException
// Responsável por definir um modelo de exceção para quando os Produtos não forem encontrados
public class UserOrderProductNotFoundException extends RuntimeException {

    // -------- Método Construtor --------
    // Construtor UserOrderProductNotFoundException
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado
    public UserOrderProductNotFoundException(String message) {
        super(message);
    }
}
