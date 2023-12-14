package com.example.blogsystem.controller;


import com.example.blogsystem.models.Blog;
import com.example.blogsystem.service.BlogServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs")
@AllArgsConstructor
public class BlogController {
    private final BlogServiceImpl blogServiceImpl;
    @PostMapping(name = "/saveBlog")
    public void saveBlog(@RequestBody Blog blog){
        blogServiceImpl.saveBlog(blog);
    }
    @GetMapping(name = "/getbyId")
    public void getBlogById(@RequestParam Integer id){
        blogServiceImpl.getBlogById(id);
    }
    @DeleteMapping
    public void deleteMapping(@RequestParam Integer id){
        blogServiceImpl.deleteBlog(id);
    }
}
