package com.example.blogsystem.service;

import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.dto.UserDtoImpl;
import com.example.blogsystem.models.User;
import com.example.blogsystem.repo.UserRepository;
import com.example.blogsystem.service.inter.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoImpl userDtoImpl;
    @Override
    public void userSave(User user){
        userRepository.save(user);

    }
    @Override
    public List<UserDto>getAllUsers(){
     return    userRepository.findAll()
             .stream()
             .map(userDtoImpl)
             .toList();
    }
    @Override
    public void deleteUser(Integer id){
       User user= userRepository.findUserById(id).orElseThrow(() -> new NoSuchElementException("user tapilmadi"));
       userRepository.delete(user);
    }

    @Override
    public UserDto getById(Integer id) {
       return userRepository.findUserById(id).stream().map(userDtoImpl).findFirst().get();
    }

}
