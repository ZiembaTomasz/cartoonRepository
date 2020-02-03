package com.ziembatomasz.crud.cartoons.service;

import com.ziembatomasz.crud.cartoons.domain.User;
import com.ziembatomasz.crud.cartoons.domain.UserDto;
import com.ziembatomasz.crud.cartoons.mapper.UserMapper;
import com.ziembatomasz.crud.cartoons.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public List<UserDto>getAllUsers(){
         return userMapper.mapToUserDto(userRepository.findAll());
    }
    public UserDto getUser(Long UserId){
        return userMapper.mapToUserDto(userRepository.getOne(UserId));
    }
    public void deleteUser(Long userId){
        userRepository.delete(userId);
    }
    public UserDto saveUser(UserDto userDto){
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
        return userMapper.mapToUserDto(user);
    }
    public UserDto getUserByName(String name){
        User user = userRepository.findByLastnameLike(name);
        return userMapper.mapToUserDto(user);
    }
}
