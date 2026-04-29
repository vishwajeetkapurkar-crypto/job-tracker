package com.vishwajeet.job_tracker.controller;

import com.vishwajeet.job_tracker.entity.User;
import com.vishwajeet.job_tracker.service.UserService;
import com.vishwajeet.job_tracker.dto.UserRequestDTO;
import com.vishwajeet.job_tracker.dto.UserResponseDTO;
import com.vishwajeet.job_tracker.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE
    @PostMapping("/users")
    public ApiResponse<UserResponseDTO> createUser(@RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.addUser(dto);

        return new ApiResponse<>(true, "User created successfully", user);
    }

    //GET BY ID
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    //UPDATE USER
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // GET ALL
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // DELETE
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}