package com.staybook.dto;

import com.staybook.entity.User;

public record UserResponse(
        Long id,
        String username,
        String role
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );
    }
}
