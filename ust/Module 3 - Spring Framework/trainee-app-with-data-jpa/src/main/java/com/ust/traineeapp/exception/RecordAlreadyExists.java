package com.ust.traineeapp.exception;

public class RecordAlreadyExists extends RuntimeException{
    public RecordAlreadyExists(String message) {
        super(message);
    }
}