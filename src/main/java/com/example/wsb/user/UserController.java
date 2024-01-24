package com.example.wsb.user;

import com.example.wsb.security.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers().stream().map(UserDTO::createFrom).collect(Collectors.toList());
    }

//    @GetMapping("/{id}")
//    public UserDTO getUser(
//            @PathVariable Integer id
//    ) {
//        return UserDTO.createFrom(userService.getUser(id));
//    }

    @PostMapping
    public void createUser(
            @RequestBody RegisterRequest request) {
        userService.addUser(request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable Integer id
    ) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(
            @PathVariable Integer id,
            @RequestBody UserUpdateRequest updateRequest
    ) {
        userService.updateUser(id, updateRequest);
    }

    @GetMapping("/{login}")
    public UserDTO findUserByLogin(
            @PathVariable String login
    ){
        return UserDTO.createFrom(userService.findUserByLogin(login).orElseThrow());
    }


}
