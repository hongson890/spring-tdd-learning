package com.example.sonny.service;

import com.example.sonny.controller.dto.UserDTO;
import com.example.sonny.entity.User;
import com.example.sonny.mapper.UserMapper;
import com.example.sonny.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.toUserDTO(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<UserDTO> searchUser(String name, Pageable pageable) {
        List<User> lst = userRepository.findUserByNameContaining(name, pageable);
        return userMapper.toListUserDto(lst);
    }
}
