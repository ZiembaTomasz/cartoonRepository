package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private String firstname;
    @Column
    @NotNull
    private String lastname;
    @Column
    private String email;

}
