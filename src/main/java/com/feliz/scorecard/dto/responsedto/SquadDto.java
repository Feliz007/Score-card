package com.feliz.scorecard.dto.responsedto;

import lombok.Data;

import java.util.List;

@Data
public class SquadDto {
    private String squadName;
    private List<String> stackNames;
}

