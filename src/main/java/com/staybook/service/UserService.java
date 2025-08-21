package com.staybook.service;

import com.staybook.dto.UserRequest;
import com.staybook.dto.UserResponse;
import com.staybook.entity.User;
import com.staybook.exception.DuplicateResourceException;
import com.staybook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserRequest userRequest) {

        if (userRepository.existsByUsername(userRequest.username())) {
            throw new DuplicateResourceException("Username already exists: " + userRequest.username());
        }
        User user = User.builder()
                .username(userRequest.username())
                .role(userRequest.role())
                .password(passwordEncoder.encode(userRequest.password()))
                .build();
        return UserResponse.fromEntity(userRepository.save(user));
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::fromEntity)
                .toList();
    }
}
