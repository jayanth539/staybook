package com.staybook.controller;

import com.staybook.dto.UserRequest;
import com.staybook.dto.UserResponse;
import com.staybook.security.JwtUtil;
import com.staybook.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    // --- Register ---
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
        UserResponse savedUser = userService.createUser(request);
        return ResponseEntity.ok(savedUser);
    }

    // --- Login ---
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );

            // Grab a role from authenticated principal
            var userDetails = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            String role = userDetails.getAuthorities().iterator().next().getAuthority();

            // Generate JWT with username and role
            String token = jwtUtil.generateToken(request.username(), role);

            return ResponseEntity.ok().body(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // Small DTO for login response
    private record AuthResponse(String token) {}
}
