package com.ust.ecomm.exception;

public class InvalidProductPriceException extends RuntimeException {
    public InvalidProductPriceException(String message){
        super(message);
    }
}
