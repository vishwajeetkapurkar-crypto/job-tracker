package com.vishwajeet.job_tracker.service;

import com.vishwajeet.job_tracker.entity.User;
import com.vishwajeet.job_tracker.repository.UserRepository;
import com.vishwajeet.job_tracker.dto.UserRequestDTO;
import com.vishwajeet.job_tracker.exception.GlobalExceptionHandler;
import com.vishwajeet.job_tracker.exception.ResourceNotFoundException;
import com.vishwajeet.job_tracker.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO addUser(UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser.getId(), savedUser.getName());
    }

    // CREATE
    public User addUser(User user) {
        return userRepository.save(user);
    }

    //GET BY ID
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    // GET ALL
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //UPDATE USER
    public User updateUser(int id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setName(updatedUser.getName());
            return userRepository.save(user);
        }

        return null;
    }

    // DELETE
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}