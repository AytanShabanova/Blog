package com.example.blogsystem.service.inter;

import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.models.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UserService {
    public void userSave(User user);
    public List<UserDto> getAllUsers();
    public void deleteUser(Integer id);
    public UserDto getById(Integer id);
}
