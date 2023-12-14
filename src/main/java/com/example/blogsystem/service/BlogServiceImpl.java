package com.example.blogsystem.service;

import com.example.blogsystem.models.Blog;
import com.example.blogsystem.repo.BlogRepository;
import com.example.blogsystem.service.inter.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    @Override
    public void saveBlog(Blog blog){
        blogRepository.save(blog);

    }
    @Override
    public Blog getBlogById(Integer id){
        return blogRepository.findById(id).orElseThrow(() -> new NoSuchElementException("blog tapilmadi"));
    }
    @Override
    public void deleteBlog(Integer id){
        Blog blog=blogRepository.findBlogById(id).orElseThrow(() -> new NoSuchElementException("blog tapilmadi"));
        blogRepository.delete(blog);
    }
}
