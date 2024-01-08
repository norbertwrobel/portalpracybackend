package com.example.wsb.user.companyhr;

import com.example.wsb.user.Role;

public record CompanyHRCreationRequest(
        String firstName,
        String lastName,
        String login,
        String password,
        String email,
        Role role
) {
}
