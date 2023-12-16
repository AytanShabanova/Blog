package com.example.blogsystem.mapper;

import com.example.blogsystem.dto.RegisterRequest;
import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.models.User;
import com.example.blogsystem.security.MyUserDetails;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-16T14:31:22-0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
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

    @Override
    public MyUserDetails toMyUserDetails(User user) {
        if ( user == null ) {
            return null;
        }

        String email = null;
        String password = null;
        Boolean isActive = null;

        email = user.getEmail();
        password = user.getPassword();
        isActive = user.getIsActive();

        MyUserDetails myUserDetails = new MyUserDetails( email, password, isActive );

        return myUserDetails;
    }

    @Override
    public User toFromRegisterRequest(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( request.email() );
        user.password( request.password() );

        return user.build();
    }
}
