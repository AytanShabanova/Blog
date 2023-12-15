package com.example.blogsystem.service.inter;

import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.models.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {
     User userSave(UserDto userDto);
     List<UserDto> getAllUsers();
     void deleteUser(Integer id);
     UserDto getById(Integer id);
     List<UserDto>getAllPage(int page,int count);
}
