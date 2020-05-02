package com.ziembatomasz.crud.cartoons.controller;

import com.ziembatomasz.crud.cartoons.domain.UserRatingDto;
import com.ziembatomasz.crud.cartoons.service.UserRatingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cartoon/{cartoonId)/")
public class UserRatingController {
    UserRatingService userRatingService;
    @RequestMapping(method = RequestMethod.GET, value = "getRating")
    public List<UserRatingDto>getRating(@RequestParam Long cartoonId){
        return userRatingService.findByCartoonId(cartoonId);
    }
    @RequestMapping(method = RequestMethod.POST, value = "addRating")
    public void addRating(@RequestBody UserRatingDto userRatingDto){
        userRatingService.addRating(userRatingDto);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateRating")
    public UserRatingDto updateUserRating(@RequestBody UserRatingDto userRatingDto){
        return userRatingService.addRating(userRatingDto);
    }
}
