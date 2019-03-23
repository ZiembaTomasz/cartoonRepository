package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    SeasonMapper seasonMapper;
    UserRatingMapper userRatingMapper;
    public UserDto mapToUserDto(final User user, final UserRating userRating){
        return new UserDto(user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                userRatingMapper.mapToUserRatingDto(userRating.)
                );

    }

}
