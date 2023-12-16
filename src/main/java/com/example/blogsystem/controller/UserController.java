package com.example.blogsystem.controller;

import com.example.blogsystem.dto.UserDto;

import com.example.blogsystem.dto.UserPageResponse;
import com.example.blogsystem.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@Validated
public class UserController {
   //Logger logger= LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userServiceImpl;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(name = "/saveUser")
    public void saveUser(@RequestBody @Valid UserDto userDto){
        userServiceImpl.userSave(userDto);
    }
    @GetMapping("/getUser")
    public UserPageResponse getUsers(@RequestParam(value = "page")int page, @RequestParam(value = "count") int count){
     //  logger.info("getAll users accept");
        return userServiceImpl.getAllUsers(page, count);
    }
    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@RequestParam Integer id){
        userServiceImpl.deleteUser(id);
    }
   @GetMapping("/getById")
    public UserDto getById(Integer id){
       return userServiceImpl.getById(id);
    }

}
