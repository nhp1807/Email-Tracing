package com.example.emailtracing.tracing.controller;

import com.example.emailtracing.tracing.model.Campain;
import com.example.emailtracing.tracing.model.User;
import com.example.emailtracing.tracing.service.CampainService;
import com.example.emailtracing.tracing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/email-tracing")
public class ApplicationController {
    @Autowired
    private CampainService campainService;
    @Autowired
    private UserService userService;

    /**
     * Get all campains
     * @return: List of campains
     */
    @GetMapping("/campain-list")
    public ResponseEntity<Object> getAllCampains() {
        List<Campain> campainList = campainService.getAllCampains();
        return ResponseEntity.status(HttpStatus.OK).body(campainList);
    }

    /**
     * Create a new campain
     * @param campain: Campain object
     * @return: Campain object
     */
    @PostMapping("/create-campain")
    public ResponseEntity<Object> createCampain(@RequestBody Campain campain) {
        campainService.createCampain(campain);
        return ResponseEntity.status(HttpStatus.OK).body(campain);
    }

    /**
     * Get campain by id
     * @param id: Campain id
     * @return: Campain object
     */
    @GetMapping("/campain/{id}")
    public ResponseEntity<Object> getCampainById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(campainService.getCampainById(id));
    }

    /**
     * Update campain
     * @param campain: Campain object
     * @return: Campain object
     */
    @PostMapping("/update-campain")
    public ResponseEntity<Object> updateCampain(@RequestBody Campain campain) {
        return ResponseEntity.status(HttpStatus.OK).body(campainService.updateCampain(campain));
    }

    /**
     * Delete campain
     * @param id: Campain id
     */
    @GetMapping("/delete-campain/{id}")
    public void deleteCampain(@PathVariable Long id) {
        campainService.deleteCampain(id);
    }

    /**
     * Get all users
     * @return: List of users
     */
    @GetMapping("/user-list")
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    /**
     * Create a new user
     * @param user: User object
     * @return: User object
     */
    @PostMapping("/create-user")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user));
    }

    /**
     * Get user by id
     * @param id: User id
     * @return: User object
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    /**
     * Update user
     * @param user: User object
     * @return: User object
     */
    @PostMapping("/update-user")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
    }

    /**
     * Delete user
     * @param id: User id
     */
    @GetMapping("/delete-user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
