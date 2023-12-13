package com.example.blogsystem.repo;

import com.example.blogsystem.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Optional<Blog>findBlogById(Integer id);
}
