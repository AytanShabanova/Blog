package com.example.blogsystem.controller;

import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.models.User;
import com.example.blogsystem.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;
    @PostMapping(name = "/saveUser")
    public void saveUser(@RequestBody  UserDto userDto){
        userServiceImpl.userSave(userDto);
    }
    @GetMapping("/getUser")
    public List<UserDto> getUsers(){
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
