package com.example.sonny.service;

import com.example.sonny.controller.dto.UserDTO;
import com.example.sonny.entity.User;
import com.example.sonny.mapper.UserMapper;
import com.example.sonny.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("test")
@SpringBootTest
public class UserServiceITest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void shouldBeAbleToGetUserById() {

        // GIVEN
        User user = new User(null, LocalDateTime.now(), "Son pham");
        userRepository.save(user);


        // WHEN
        UserDTO userFound = userService.getUserById(user.getId());

        // THEN
        assertEquals("Son pham", userFound.getName());

        assertEquals(1, userFound.getId());
    }
}
