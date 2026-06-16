package com.example.Job_Portal.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;


public record ContactRequestDto(
        @NotNull(message = "Email is required")
        @Email(message = "Invalid email format")
        @Size(min = 5,max = 500,message = "Email must be between 5 and 500 characters")
        String email,

        @NotNull(message = "message is required")
        @Size(min = 5,max =250,message = "message must be between 5 and 250 characters")
        String message,

        @NotNull(message = "name is required")
        @Size(min = 5,max =30,message = "name must be between 5 and 30 characters")
        String name,

        @NotNull(message = "subject is required")
        @Size(min = 5,max =150,message = "subject must be between 5 and 150 characters")
        String subject,

        @NotNull(message = "userType is required")
        @Pattern(regexp = "Job Seeker|Employer|Other", message = "userType must be either 'Job Seeker', 'Employer', or 'Other'")
        String userType) implements Serializable {
}