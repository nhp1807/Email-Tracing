package com.example.emailtracing.tracing.service;

import com.example.emailtracing.tracing.dto.UserDTO;
import com.example.emailtracing.tracing.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User createUser(User user);
    UserDTO getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
}
