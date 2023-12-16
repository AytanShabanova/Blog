package com.example.blogsystem.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserDto(
        @NotNull
        @NotEmpty
        @NotBlank
        @Email
        @Size(min = 4)
        String fullName,
        LocalDate age) {

}
