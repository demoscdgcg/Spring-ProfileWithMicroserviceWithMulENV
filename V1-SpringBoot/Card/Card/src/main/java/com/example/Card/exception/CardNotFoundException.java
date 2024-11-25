package com.example.Card.exception;

public class CardNotFoundException extends RuntimeException{

    public CardNotFoundException(String message,String mobileno){
        super(String.format("%s not found with given data %s",message,mobileno));
    }
}
