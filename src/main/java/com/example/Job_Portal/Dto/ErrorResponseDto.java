package com.example.Job_Portal.Dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDto(String apiPath, HttpStatus errorCode,
                               String errorMessage, LocalDateTime errorTime) {
}
