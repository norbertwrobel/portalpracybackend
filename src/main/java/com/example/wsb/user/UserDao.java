package com.example.wsb.user;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> selectAllUsers();
    User selectUserById(Integer id);
    void insertUser(User user);
    boolean existsPersonWithEmail(String email);
    void deleteUserById(Integer userId);
    boolean existsPersonWithId(Integer id);

    void updateUser(User update);

}
