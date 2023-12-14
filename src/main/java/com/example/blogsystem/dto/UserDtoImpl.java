package com.example.blogsystem.dto;

import com.example.blogsystem.models.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserDtoImpl implements Function<User,UserDto> {
    @Override
    public UserDto apply(User user) {
        return new UserDto(
                user.getFullName(),
                user.getAge());
    }
}
