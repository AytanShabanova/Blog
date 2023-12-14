package com.example.blogsystem.service.inter;

import com.example.blogsystem.models.Blog;

public interface BlogService {
    public void saveBlog(Blog blog);
    public Blog getBlogById(Integer id);
    public void deleteBlog(Integer id);
}
