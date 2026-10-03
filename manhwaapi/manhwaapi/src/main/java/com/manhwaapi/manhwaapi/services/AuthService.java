package com.manhwaapi.manhwaapi.services;

import com.manhwaapi.manhwaapi.dto.AuthResponse;
import com.manhwaapi.manhwaapi.dto.LoginRequest;
import com.manhwaapi.manhwaapi.dto.RegisterRequest;
import com.manhwaapi.manhwaapi.model.User;
import com.manhwaapi.manhwaapi.repository.UserRepository;
import com.manhwaapi.manhwaapi.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exists");
        }

        String hashedPassword =
                passwordEncoder.encode(request.password());

        User user = new User(
                request.username(),
                hashedPassword
        );

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository
                .findByUsername(request.username())
                .orElseThrow(() ->
                        new RuntimeException("Invalid username or password")
                );

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.password(),
                        user.getPassword()
                );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtService.generateToken(
                user.getUsername()
        );

        return new AuthResponse(token);
    }
}
