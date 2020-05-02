package com.ziembatomasz.crud.cartoons.mapper;


import com.ziembatomasz.crud.cartoons.domain.User;
import com.ziembatomasz.crud.cartoons.domain.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserMapper {
    SeasonMapper seasonMapper;
    UserRatingMapper userRatingMapper;

    public UserDto mapToUserDto(final User user){
        return new UserDto(user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail());
    }

    public List<User> mapToUsers (final List<UserDto>userRatings){
        return userRatings.stream()
                .map(this::mapToUser)
                .collect(Collectors.toList());
    }
    public User mapToUser(final UserDto userDto){
        return new User(userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getEmail());
    }
    public List<UserDto>mapToUserDto(final List<User>users){
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
