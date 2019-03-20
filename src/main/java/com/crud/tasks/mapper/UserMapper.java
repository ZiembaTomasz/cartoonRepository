package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    SeasonMapper seasonMapper;
    public UserDto mapToUserDto(final User user){
        return new UserDto(user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                mapToUserRatingDto().
                );

    }

    public List<UserRatingDto> mapToUserRatingDto(final List<UserRating>userRatings){
        return userRatings.stream()
                .map(this::mapToUserRatingDto)
                .collect(Collectors.toList());
    }
    public UserRatingDto mapToUserRatingDto(final UserRating userRating, final User user){
        return new UserRatingDto( userRating.getId(),
        user.getId());

    }
}
