package com.cupcakestore.store.exceptions;

// Classe UserNotFoundException
// Responsável por definir um modelo de exceção para quando os Produtos não forem encontrados
public class UserNotFoundException extends RuntimeException {

    // -------- Método Construtor --------
    // Construtor UserNotFoundException
    // Lembrete: O método construtor define o estado/ação de um objeto dessa classe
    // assim que ele for instanciado
    public UserNotFoundException(String message) {
        super(message);
    }
}
