package com.feliz.scorecard.exceptions;

public class UserNotFoundException  extends  RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

}
