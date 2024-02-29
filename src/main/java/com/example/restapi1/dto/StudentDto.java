package com.example.restapi1.dto;

public record StudentDto(
    String firstName,
    String lastName,
    String email, 
    int schoolId
) {
    
}
