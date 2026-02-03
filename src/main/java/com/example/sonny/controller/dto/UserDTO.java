package com.example.sonny.controller.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class UserDTO {
    Integer id;
    LocalDateTime createdAt;
    String name;
}
