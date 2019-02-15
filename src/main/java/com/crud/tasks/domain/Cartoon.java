package com.crud.tasks.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cartoons")
@Data
public class Cartoon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private int ageRestriction;
    @Column
    private double rating;
}
