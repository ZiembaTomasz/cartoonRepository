package com.ziembatomasz.crud.cartoons.service;

import com.ziembatomasz.crud.cartoons.domain.UserRating;
import com.ziembatomasz.crud.cartoons.domain.UserRatingDto;
import com.ziembatomasz.crud.cartoons.mapper.UserRatingMapper;
import com.ziembatomasz.crud.cartoons.repository.UserRatingRepository;
import com.ziembatomasz.crud.cartoons.repository.UserRepository;
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
    public void addRating(UserRatingDto userRatingDto){
        UserRating userRating = userRatingMapper.mapToUserRating(userRatingDto);
        userRatingRepository.save(userRating);
    }
}
