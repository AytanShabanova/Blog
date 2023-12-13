package com.example.blogsystem.controller;


import com.example.blogsystem.models.Blog;
import com.example.blogsystem.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs")
@AllArgsConstructor
public class BlogController {
    private final BlogService blogService;
    @PostMapping(name = "/saveBlog")
    public void saveBlog(@RequestBody Blog blog){
        blogService.saveBlog(blog);
    }
    @GetMapping(name = "/getbyId")
    public void getBlogById(@RequestParam Integer id){
        blogService.getBlogById(id);
    }
}
