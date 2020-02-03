package com.ziembatomasz.crud.cartoons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeasonDto {
    private Long id;
    private String name;
    private int numberOfSeasons;

}
