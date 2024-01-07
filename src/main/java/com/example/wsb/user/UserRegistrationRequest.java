package com.example.wsb.user;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        String email,
        Role role
){
}
