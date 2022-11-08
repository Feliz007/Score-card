package com.feliz.scorecard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class StackTemplate  extends BaseClass{
    private String stackName;
}
