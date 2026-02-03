package com.example.sonny.controller;

import com.example.sonny.controller.dto.UserDTO;
import com.example.sonny.entity.User;
import com.example.sonny.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/searchUser")
    public List<UserDTO> searchUser(@RequestParam(value="name") String name, Pageable pageable) {
        return userService.searchUser(name, pageable);
    }

}
