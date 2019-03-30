package com.crud.tasks.service;

import com.crud.tasks.domain.User;
import com.crud.tasks.domain.UserDto;
import com.crud.tasks.mapper.UserMapper;
import com.crud.tasks.repository.UserRepository;
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
