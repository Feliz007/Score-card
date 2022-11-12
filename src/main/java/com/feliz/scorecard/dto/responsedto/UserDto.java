package com.feliz.scorecard.dto.responsedto;

import com.feliz.scorecard.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Role role;

}
