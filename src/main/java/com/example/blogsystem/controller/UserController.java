package com.example.blogsystem.controller;

import com.example.blogsystem.models.User;
import com.example.blogsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @PostMapping(name = "/saveUser")
    public void saveUser(@RequestBody  User user){
        userService.userSave(user);
    }
    @GetMapping("/getUser")
    public void getUsers(){
        userService.getAllUsers();
    }

}
