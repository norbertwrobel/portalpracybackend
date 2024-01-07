package com.example.wsb.user;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        String email,
        Role role
) {
}
