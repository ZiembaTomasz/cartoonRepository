package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Episod {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "seasonID")
    private Season season;

}
