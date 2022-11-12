package com.feliz.scorecard.dto;

import com.feliz.scorecard.enums.Gender;
import com.feliz.scorecard.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecadevDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String decadevId;
    private Role role;




}
