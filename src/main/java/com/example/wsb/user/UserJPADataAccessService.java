package com.example.wsb.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserJPADataAccessService implements UserDao {

    private final UserRepository userRepository;

    public UserJPADataAccessService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User selectUserById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean existsPersonWithId(Integer id) {
        return userRepository.existsUserById(id);
    }

    @Override
    public void updateUser(User update) {
        userRepository.save(update);
    }
}
