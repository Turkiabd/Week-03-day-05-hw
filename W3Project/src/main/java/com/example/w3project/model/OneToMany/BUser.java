package com.example.w3project.model.OneToMany;


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
public class BUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;
    @NotEmpty(message = "password is required")
    private String password ;

    @OneToMany(mappedBy = "user")
    private Set<Book> bookSet;

}
