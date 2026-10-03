package com.manhwaapi.manhwaapi.services;

import com.manhwaapi.manhwaapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@Transactional()
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEnconder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEnconder) {
        this.userRepository = userRepository;
        this.passwordEnconder = passwordEnconder;
    }

}
