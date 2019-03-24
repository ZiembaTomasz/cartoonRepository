package com.crud.tasks.mapper;

import com.crud.tasks.domain.User;
import com.crud.tasks.domain.UserRating;
import com.crud.tasks.domain.UserRatingDto;
import com.crud.tasks.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRatingMapper {
    UserRepository userRepository;


    public List<UserRatingDto> mapToUserRatingDto(List<UserRating>userRatings){
        return userRatings.stream()
                .map(this::mapToUserRatingDto)
                .collect(Collectors.toList());
    }
    public UserRatingDto mapToUserRatingDto( UserRating userRating){
        return new UserRatingDto( userRating.getId(),
                userRating.getRating(),
                userRating.getUser().getId(),
                userRating.getCartoonId());
    }
    public UserRating mapToUserRating(UserRatingDto userRatingDto){
        return new UserRating(userRatingDto.getId(),
                userRatingDto.getRating(),
                userRepository.findOne(userRatingDto.getUserId()),
                        userRatingDto.getCartoonId());
    }
    public List<UserRating> mapToUserRating(List<UserRatingDto>userRatingDtos){
        return userRatingDtos.stream()
                .map(this::mapToUserRating)
                .collect(Collectors.toList());
    }
    ////
}
