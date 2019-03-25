package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRatingDto {
    private Long id;
    private int rating;
    private Long userId;
    private Long cartoonId;
}
