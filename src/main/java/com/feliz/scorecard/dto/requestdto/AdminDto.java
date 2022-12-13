package com.feliz.scorecard.dto.requestdto;

import com.feliz.scorecard.enums.AssignRole;
import com.feliz.scorecard.enums.Gender;
import com.feliz.scorecard.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminDto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private AssignRole assignRole;
    private Long squadId;
    private Long stackId;
    private Long podId;
    private Role role;
}