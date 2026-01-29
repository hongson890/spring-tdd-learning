package com.example.sonny;

import com.example.sonny.repository.UserRepository;
import com.example.sonny.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldBeAbleToGetUserByName() {

    }
}
