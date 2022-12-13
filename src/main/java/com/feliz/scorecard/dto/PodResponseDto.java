package com.feliz.scorecard.dto;


import com.feliz.scorecard.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodResponseDto {
    private  String podName;
    private List<Admin> admin = new ArrayList<>();
}
