package com.feliz.scorecard.model;

import com.feliz.scorecard.enums.AssignRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "admin")
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{
    @Enumerated(EnumType.STRING)
    private AssignRole assignRole;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "admin_squad", referencedColumnName = "id")
    private List<Squad> squads;
    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "stack_admin",referencedColumnName = "id")
    private List<Stack> stacks;
    @JsonBackReference
    @ManyToMany
    @JoinColumn(name = "admin_pod",referencedColumnName = "id")
    private List<Pod> pods;
}
