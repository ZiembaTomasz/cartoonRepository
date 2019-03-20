package com.crud.tasks.mapper;

import com.crud.tasks.domain.User;
import com.crud.tasks.domain.UserRating;
import com.crud.tasks.domain.UserRatingDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRatingMapper {
    public List<UserRatingDto> mapToUserRatingDto(List<UserRating>userRatings, User user){
        return userRatings.stream()
                .map(t-> mapToUserRatingDto(t, user))
                .collect(Collectors.toList());
    }
    public UserRatingDto mapToUserRatingDto( UserRating userRating,  User user){
        return new UserRatingDto( userRating.getId(),
                userRating.getRating(),
                user.getId());

    }
    public UserRating mapToUserRating(UserRatingDto userRatingDto, User user ){
        return new UserRating(userRatingDto.getId(),
                userRatingDto.getRating(),
                user,
                user.getId());
    }
    public List<UserRating> mapToUserRating(List<UserRatingDto>userRatingDtos, User user){
        return userRatingDtos.stream()
                .map(t-> mapToUserRating(t, user))
                .collect(Collectors.toList());
    }
}
