package com.ziembatomasz.crud.cartoons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private Long cartoonId;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private int numberOfSeasons;


}
