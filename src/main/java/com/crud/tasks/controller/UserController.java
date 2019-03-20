package com.crud.tasks.controller;

import com.crud.tasks.domain.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@AllArgsConstructor
@RestController
public class UserController {
    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers(){

    }
    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId{

    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public UserDto deleteUser(@RequestParam Long userId){

    }
    @RequestMapping(method = RequestMethod.POST, value = "addUser")
    public void addUser(@RequestBody UserDto userDto){

    }
}
