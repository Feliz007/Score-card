package com.feliz.scorecard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "decadev")
@AllArgsConstructor
@NoArgsConstructor
public class Decadev extends User{

    private String decadevId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadev_squad", referencedColumnName = "id")
    private Squad squad;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "decadev_stack", referencedColumnName = "id")
    private Stack stack;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "dev_pod",referencedColumnName = "id")
    private Pod pod;
    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<Algorithm> algorithm = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<AgileTest> agileTests = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<AssessmentTest> assessmentTests = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<QATest> QATests = new ArrayList<>();

    @JsonBackReference
    @ManyToMany(mappedBy = "decadev")
    private List<WeeklyTask> weeklyTasks = new ArrayList<>();

}