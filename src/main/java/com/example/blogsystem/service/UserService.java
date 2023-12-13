package com.example.blogsystem.service;

import com.example.blogsystem.models.User;
import com.example.blogsystem.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void userSave(User user){
        userRepository.save(user);

    }
    public List<User>getAllUsers(){
     return    userRepository.findAll();
    }

}
