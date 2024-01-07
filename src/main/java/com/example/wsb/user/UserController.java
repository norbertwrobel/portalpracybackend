package com.example.wsb.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public User getUser(
            @PathVariable("userId") Integer userId
    ){
        return userService.getUser(userId);
    }

    @PostMapping
    public void registerUser(
            @RequestBody UserRegistrationRequest request){
        userService.addUser(request);
    }

    @DeleteMapping("userId")
    public void deleteUser(
            @PathVariable("userId") Integer userId
    ){
        userService.deleteUserById(userId);
    }


}
