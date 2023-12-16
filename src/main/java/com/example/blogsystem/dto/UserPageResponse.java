package com.example.blogsystem.dto;

import java.util.List;

public record UserPageResponse(
        List<UserDto>users,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
