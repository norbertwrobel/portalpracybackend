package com.example.wsb.user;

import com.example.wsb.exception.DuplicateResourceException;
import com.example.wsb.exception.RequestValidationException;
import com.example.wsb.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers(){
        return userDao.selectAllUsers();
    }

    public User getUser(Integer id){
        return userDao.selectUserById(id);
    }

    public void addUser(UserRegistrationRequest userRegistrationRequest){
        String email = userRegistrationRequest.email();
        if (userDao.existsPersonWithEmail(email)){
            throw new DuplicateResourceException("email already taken");
        }
        User user = new User(
                userRegistrationRequest.firstName(),
                userRegistrationRequest.lastName(),
                userRegistrationRequest.username(),
                userRegistrationRequest.password(),
                userRegistrationRequest.email(),
                userRegistrationRequest.role()
        );
        userDao.insertUser(user);
    }

    public void deleteUserById (Integer userId){
        if(!userDao.existsPersonWithId(userId)){
            throw new ResourceNotFoundException(
                    "user with id [%s] not found". formatted(userId)
            );
        }
        userDao.deleteUserById(userId);
    }

    public void updateUser(Integer userId, UserUpdateRequest updateRequest){
        User user = getUser(userId);

        boolean changes = false;

        if(updateRequest.firstName() != null && !updateRequest.firstName().equals(user.getFirstName())){
            user.setFirstName(updateRequest.firstName());
            changes = true;
        }

        if(updateRequest.lastName() != null && !updateRequest.lastName().equals(user.getLastName())){
            user.setLastName(updateRequest.lastName());
            changes = true;
        }

        if(updateRequest.username() != null && !updateRequest.username().equals(user.getUsername())){
            user.setUsername(updateRequest.username());
            changes = true;
        }

        if(updateRequest.password() != null && !updateRequest.password().equals(user.getPassword())){
            user.setPassword(updateRequest.password());
            changes = true;
        }

        if(updateRequest.email() != null && !updateRequest.email().equals(user.getEmail())){
            if (userDao.existsPersonWithEmail(updateRequest.email())){
                throw new DuplicateResourceException(
                        "email already taken"
                );
            }
            user.setEmail(updateRequest.email());
            changes = true;
        }

        if(updateRequest.role() != null && !updateRequest.role().equals(user.getRole())){
            user.setRole(updateRequest.role());
            changes = true;
        }

        if (!changes){
            throw new RequestValidationException("no user changes found");
        }

        userDao.updateUser(user);
    }




}
