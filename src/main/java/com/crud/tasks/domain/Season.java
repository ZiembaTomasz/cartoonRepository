package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long cartoonId;
    @Column
    private String name;
//    @ManyToOne
//    @JoinColumn(name="cartoonId")
//    private Cartoon cartoon;

}
