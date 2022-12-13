package com.feliz.scorecard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.feliz.scorecard.enums.AssignRole;
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

    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(name = "admin_squad",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "squad_id")})
    private List<Squad> squads;
    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(name = "admin_stack",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "stack_id")})
    private List<Stack> stacks;
    @JsonBackReference
    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(name = "admin_pod",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "pod_id")})
    private List<Pod> pods;
}
