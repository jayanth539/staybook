package com.staybook.service;

import com.staybook.dto.UserRequest;
import com.staybook.dto.UserResponse;
import com.staybook.entity.User;
import com.staybook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.username())
                .role(userRequest.role())
                .password(userRequest.password())
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
