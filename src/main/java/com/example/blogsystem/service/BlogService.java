package com.example.blogsystem.service;

import com.example.blogsystem.models.Blog;
import com.example.blogsystem.repo.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    public void saveBlog(Blog blog){
        blogRepository.save(blog);

    }
    public Blog getBlogById(Integer id){
        return blogRepository.findById(id).orElseThrow(() -> new NoSuchElementException("blog tapilmadi"));
    }
    public void deleteBlog(Integer id){
        Blog blog=blogRepository.findBlogById(id).orElseThrow(() -> new NoSuchElementException("blog tapilmadi"));
        blogRepository.delete(blog);
    }
}
