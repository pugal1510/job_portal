package com.example.Job_Portal.Dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


public record ContactRequestDto(
        @NotNull(message = "Email is required")
        String email,
        @NotNull(message = "message is required")
        String message,
        @NotNull(message = "name is required")
        String name,
        @NotNull(message = "subject is required")
        String subject,
        @NotNull(message = "userType is required")
        String userType) implements Serializable {
}