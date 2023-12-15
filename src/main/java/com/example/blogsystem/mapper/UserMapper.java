package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUserEntity(UserDto userDto);
}
