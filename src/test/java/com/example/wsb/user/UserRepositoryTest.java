package com.example.wsb.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByUsername_thenReturnUser() {
        // given
        User user = new User("John", "Doe", "john@example.com", "password", "role");

        // when
        User found = userRepository.findByUsername(user.getUsername());

        // then
        assertThat(found.getUsername())
                .isEqualTo(user.getUsername());

        assertThat(found.getFirstName())
                .isEqualTo(user.getFirstName());

        assertThat(found.getLastName())
                .isEqualTo(user.getLastName());

        assertThat(found.getEmail())
                .isEqualTo(user.getEmail());

        assertThat(found.getPassword())
                .isEqualTo(user.getPassword());

        assertThat(found.getRole())
                .isEqualTo(user.getRole());
    }
}