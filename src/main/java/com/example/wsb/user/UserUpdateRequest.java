package com.example.wsb.user;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        String login,
        String password,
        String email,
        Role role
) {
}
