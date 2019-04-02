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
public class UserRating {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    @NotNull
    private int rating;
    @ManyToOne
    @JoinColumn(name ="userId")
    private User user;
    @Column
    private Long cartoonId;
}
