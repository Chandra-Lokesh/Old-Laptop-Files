package com.ust.ecomm.exception;

public class InvalidProductIdException extends RuntimeException{
    public InvalidProductIdException(String message){
        super(message);
    }
}
