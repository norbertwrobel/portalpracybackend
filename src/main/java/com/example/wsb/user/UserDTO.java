package com.example.wsb.user;

import com.example.wsb.user.companyhr.CompanyHR;

public record UserDTO(Integer userId, CompanyHR companyHr,String firstName,String lastName,String login,String password,String email,Role role) {
    public static UserDTO createFrom(User user){
        return new UserDTO(user.getUserId(),user.getCompanyHr(),user.getFirstName(),user.getLastName(),user.getLogin(),user.getPassword(),user.getEmail(),user.getRole());
    }
}
