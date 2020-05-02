package com.ziembatomasz.crud.cartoons.controller;

import com.ziembatomasz.crud.cartoons.domain.UserDto;
import com.ziembatomasz.crud.cartoons.mapper.UserMapper;
import com.ziembatomasz.crud.cartoons.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@AllArgsConstructor
@RestController
public class UserController {
    UserService userService;
    UserMapper userMapper;
    @RequestMapping(method = RequestMethod.GET, value = "/getUsers")
    public List<UserDto> getUsers(){
        return userService.getAllUsers();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    public UserDto getUser(@RequestParam Long userId){
        return userService.getUser(userId);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    public void deleteUser(@RequestParam Long userId){
        userService.deleteUser(userId);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/createUser")
    public void createUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getUserByName")
    public UserDto getUserByName(@RequestParam String name){
        return userService.getUserByName(name + "%");
    }
}
