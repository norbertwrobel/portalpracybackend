package com.example.wsb.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //User findByUsername(String username);

    boolean existsUserByEmail(String email);
    boolean existsUserByUserId(Integer id);
    Optional<User> findUserByLogin(String login);

    //@Query("select u from User u left join fetch u.companyHr")
   // List<User> findAllUsersWithLeftJoinFetch();

    //TODO TO SAMO TYLKO KURWA ZAMIAST USER T O CANDIDATE

}
