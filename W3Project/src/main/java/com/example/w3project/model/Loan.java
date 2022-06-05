package com.example.w3project.model;

import com.example.w3project.model.OneToMany.Book;
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
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    @NotEmpty(message = "user id is required")
    private Integer userId;
    @NotEmpty(message = "book id is required")
    private Integer bookId ;


    @ManyToMany
    @JsonIgnore
    private Set<Book> bookSet;


}
