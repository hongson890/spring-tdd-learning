package com.example.sonny.service;

import com.example.sonny.controller.dto.UserDTO;
import com.example.sonny.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDTO getUserById(int id);

    List<UserDTO> searchUser(String name, Pageable pageable);
}