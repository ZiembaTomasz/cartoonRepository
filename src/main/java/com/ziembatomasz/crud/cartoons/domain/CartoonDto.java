package com.ziembatomasz.crud.cartoons.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CartoonDto {
    private Long id;
    private String name;
    private int ageRestriction;
    private double rating;
    private Date date;
    private List<SeasonDto> seasonDtos;
}
