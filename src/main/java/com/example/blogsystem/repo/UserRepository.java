package com.example.blogsystem.repo;

import com.example.blogsystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User>findUserById(Integer id);

}
