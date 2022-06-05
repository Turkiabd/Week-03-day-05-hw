package com.example.w3project.model.OneToMany;


import com.example.w3project.model.Loan;
import com.example.w3project.model.OneToMany.BUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    @NotEmpty(message = "name is required")
    private String name;
    @NotEmpty(message = "genre is required")
    private String genre ;


    @ManyToOne
    @JsonIgnore
    private BUser user;


    @ManyToMany(mappedBy = "bookSet")
    private Set<Loan> loanSet;


}
