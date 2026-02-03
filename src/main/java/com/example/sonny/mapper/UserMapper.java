package com.example.sonny.mapper;

import com.example.sonny.controller.dto.UserDTO;
import com.example.sonny.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public List<UserDTO> toListUserDto(List<User> userList) {
        return userList.stream()
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }
}
