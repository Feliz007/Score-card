package com.feliz.scorecard.controller;

import com.feliz.scorecard.dto.responsedto.APIResponse;
import com.feliz.scorecard.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<APIResponse> userNotFoundException(UserNotFoundException exception){
        return new ResponseEntity<>(new APIResponse<>(true, exception.getMessage(), null), HttpStatus.NOT_FOUND);
    }



}




