package com.example.sonny.service;

import com.example.sonny.controller.dto.UserDTO;
import com.example.sonny.entity.User;
import com.example.sonny.mapper.UserMapper;
import com.example.sonny.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceUTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Test
    void shouldReturnUserWhenIdExists() {
        // GIVEN
        User user = new User(1, LocalDateTime.now(), "son pham");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(userMapper.toUserDTO(user)).thenReturn(UserDTO.builder()
                        .name(user.getName())
                .build());

        // WHEN
        UserDTO result = userService.getUserById(1);

        // THEN
        assertEquals("son pham", result.getName());
    }
}
