package com.example.wsb.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //User findByUsername(String username);

    boolean existsUserByEmail(String email);
    boolean existsUserByUserId(Integer id);
    Optional<User> findUserByLogin(String login);

}
