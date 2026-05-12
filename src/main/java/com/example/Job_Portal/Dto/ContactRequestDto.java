package com.example.Job_Portal.Dto;

import java.io.Serializable;


public record ContactRequestDto(String email, String message, String name, String subject,
                                String userType) implements Serializable {
}