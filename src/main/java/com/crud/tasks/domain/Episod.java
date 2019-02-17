package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "episods")
public class Episod {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "seasonID")
    private Season season;

}
