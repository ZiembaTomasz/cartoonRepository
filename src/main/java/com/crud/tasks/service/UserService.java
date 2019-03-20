package com.crud.tasks.service;

import com.crud.tasks.domain.UserDto;
import com.crud.tasks.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public List<UserDto>getAllUsers(){

    }
}
