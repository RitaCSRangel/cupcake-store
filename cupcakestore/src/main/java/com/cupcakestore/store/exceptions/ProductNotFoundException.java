package com.cupcakestore.store.exceptions;

public class ProductNotFoundException extends RuntimeException{

    // Constructor
    public ProductNotFoundException(String message){
        super(message);
    }
}
