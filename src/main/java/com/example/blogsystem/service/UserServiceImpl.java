package com.example.blogsystem.service;

import com.example.blogsystem.config.PasswordConfig;
import com.example.blogsystem.dto.RegisterRequest;
import com.example.blogsystem.dto.UserDto;
import com.example.blogsystem.dto.UserPageResponse;
import com.example.blogsystem.exception.NotFoundUserException;
import com.example.blogsystem.mapper.UserMapper;
import com.example.blogsystem.models.User;
import com.example.blogsystem.repo.UserRepository;
import com.example.blogsystem.service.inter.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User userSave(UserDto userDto){
      return   userRepository.save(mapper.toUserEntity(userDto));


    }
    @Override
    public UserPageResponse getAllUsers(int page, int count){
        Page<User> userPage = userRepository.findAll(PageRequest.of(page, count));
        return   new UserPageResponse(
                userPage.getContent().stream().map(mapper::toUserDto).toList(),
                userPage.getTotalElements(),
                userPage.getTotalPages(),
                userPage.hasNext()
        );
    }
    @Override
    public void deleteUser(Integer id){
       User user= userRepository.findUserById(id).orElseThrow(() -> new NoSuchElementException("user tapilmadi"));
       userRepository.delete(user);
    }

    @Override
    public UserDto getById(Integer id) {
       return userRepository.findUserById(id).stream().map(mapper::toUserDto ).findFirst().orElseThrow(() -> new NotFoundUserException("User tapilmadi"));
    }

    @Override
    public List<UserDto> getAllPage(int page, int count) {
        Page<User> users=userRepository.findAll(PageRequest.of(page, count));
        return users.getContent()
                .stream()
                .map(mapper::toUserDto)
                .toList();

    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new NoSuchElementException("user tapilmadi"));
    }

    @Override
    public void register(RegisterRequest request) {
      User user=  mapper.toFromRegisterRequest(request);
      user.setPassword(passwordEncoder.encode(request.password()));
        userRepository.save(user);

    }

}
