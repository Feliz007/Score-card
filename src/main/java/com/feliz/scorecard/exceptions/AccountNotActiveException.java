package com.feliz.scorecard.exceptions;

public class AccountNotActiveException extends RuntimeException{
    public AccountNotActiveException(String message){
        super(message);
    }
}
