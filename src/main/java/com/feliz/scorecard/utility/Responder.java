package com.feliz.scorecard.utility;


import com.feliz.scorecard.dto.responsedto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Responder {
    public static ResponseEntity<APIResponse<?>> successful(Object response){
        return  new  ResponseEntity<>(new APIResponse<>(true,"Request Successful",  response), HttpStatus.OK);
    }

}
