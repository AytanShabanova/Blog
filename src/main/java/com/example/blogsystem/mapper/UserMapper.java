package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.RegisterRequest;
import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.models.User;
import com.example.blogsystem.security.MyUserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUserEntity(UserDto userDto);
    MyUserDetails toMyUserDetails(User user);
    User toFromRegisterRequest(RegisterRequest request);
}
