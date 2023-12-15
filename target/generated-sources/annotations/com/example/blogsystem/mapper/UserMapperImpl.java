package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.models.User;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-14T23:28:05-0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        String fullName = null;
        LocalDate age = null;

        fullName = user.getFullName();
        age = user.getAge();

        UserDto userDto = new UserDto( fullName, age );

        return userDto;
    }

    @Override
    public User toUserEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.fullName( userDto.fullName() );
        user.age( userDto.age() );

        return user.build();
    }
}
