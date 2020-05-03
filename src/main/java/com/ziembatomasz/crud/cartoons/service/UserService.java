package com.ziembatomasz.crud.cartoons.service;

import com.ziembatomasz.crud.cartoons.domain.User;
import com.ziembatomasz.crud.cartoons.domain.UserDto;
import com.ziembatomasz.crud.cartoons.exception.UserNotFoundException;
import com.ziembatomasz.crud.cartoons.mapper.UserMapper;
import com.ziembatomasz.crud.cartoons.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.internal.util.Contracts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
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
    public UserDto saveUser(UserDto userDto){
        Contracts.assertNotNull(userDto.getId(), "Cannot save without id");
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
        return userMapper.mapToUserDto(user);
    }
    public UserDto updateUser(UserDto userDto){
        Contracts.assertNotNull(userDto.getId(), "Cannot update without id");
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
        return userMapper.mapToUserDto(user);

    }
    public void deleteUser(Long userId){
        userRepository.delete(userId);
    }
    public UserDto getUserByName(String name){
        User user = userRepository.findByLastnameLike(name);
        return userMapper.mapToUserDto(user);
    }
}
