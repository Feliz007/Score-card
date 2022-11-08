package com.feliz.scorecard.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse<T>{
    private String message;
    private LocalDateTime time;
    private T data;
}
