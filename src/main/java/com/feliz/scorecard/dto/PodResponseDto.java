package com.feliz.scorecard.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodResponseDto {
    private  String podName;
    private String stackAssociateByEmail;
    private String programAssociateByEmail;


}
