

package com.feliz.scorecard.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgileTest extends BaseClass{

    private double score;
    private String week;
    private String mont;

    @JsonManagedReference
    @ManyToMany
    @JoinColumn(name = "dev_agile",referencedColumnName = "id")
    private List<Decadev> decadev = new ArrayList<>();
}
