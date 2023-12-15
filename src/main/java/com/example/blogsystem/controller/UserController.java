package com.example.blogsystem.controller;

import com.example.blogsystem.dto.UserDto;

import com.example.blogsystem.service.UserServiceImpl;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
   //Logger logger= LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userServiceImpl;
    @PostMapping(name = "/saveUser")
    public void saveUser(@RequestBody  UserDto userDto){
        userServiceImpl.userSave(userDto);
    }
    @GetMapping("/getUser")
    public List<UserDto> getUsers(){
     //   logger.info("getAll users accept");
        return userServiceImpl.getAllUsers();
    }
    @DeleteMapping
    public void deleteUser(@RequestParam Integer id){
        userServiceImpl.deleteUser(id);
    }
    @GetMapping("/getById")
    public UserDto getById(Integer id){
       return userServiceImpl.getById(id);
    }

}
