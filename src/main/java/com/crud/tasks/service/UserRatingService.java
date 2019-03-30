package com.crud.tasks.service;

import com.crud.tasks.domain.UserRating;
import com.crud.tasks.domain.UserRatingDto;
import com.crud.tasks.mapper.UserRatingMapper;
import com.crud.tasks.repository.UserRatingRepository;
import com.crud.tasks.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserRatingService {
    UserRatingRepository userRatingRepository;
    UserRatingMapper userRatingMapper;
    UserRepository userRepository;
    public List<UserRatingDto>findByCartoonId(Long cartoonId){
         List<UserRating> userRatings = userRatingRepository.findUserRatingByCartoonId(cartoonId);
         return userRatingMapper.mapToUserRatingDto(userRatings);
    }
    public UserRatingDto addRating(UserRatingDto userRatingDto){
        UserRating userRating = userRatingMapper.mapToUserRating(userRatingDto);
        userRatingRepository.save(userRating);
        return userRatingMapper.mapToUserRatingDto(userRating);

    }
}
