package com.feliz.scorecard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "squad")
@AllArgsConstructor
@NoArgsConstructor
public class Squad extends BaseClass {

    private String squadName;
    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "stack_squad", referencedColumnName = "id")
    private List<Stack> stacks;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "stack_admin", referencedColumnName = "id")
    private List<Admin> admin;

    @JsonBackReference
    @OneToMany(mappedBy = "squad")
    private List<Decadev> decadev;
}
