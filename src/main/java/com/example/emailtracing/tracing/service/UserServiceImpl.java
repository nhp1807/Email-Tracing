package com.example.emailtracing.tracing.service;

import com.example.emailtracing.tracing.dto.UserDTO;
import com.example.emailtracing.tracing.model.InfoMedia;
import com.example.emailtracing.tracing.model.User;
import com.example.emailtracing.tracing.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        String jsonInfo = user.getInfo();
        ObjectMapper mapper = new ObjectMapper();
        try {
            HashMap<String, InfoMedia> infoHashMap = mapper.readValue(jsonInfo, HashMap.class);
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setEmail(user.getEmail());
            userDTO.setInfoMedia(infoHashMap);
            userDTO.setFullName(user.getFullName());
            userDTO.setUpdatedAt(user.getUpdatedAt());
            userDTO.setCreatedAt(user.getCreatedAt());
            return userDTO;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
