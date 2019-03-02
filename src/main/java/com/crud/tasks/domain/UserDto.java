package com.crud.tasks.domain;

import java.util.List;

public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private List<UserRating> userRatingList;
}
