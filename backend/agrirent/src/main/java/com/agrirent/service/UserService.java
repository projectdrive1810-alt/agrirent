package com.agrirent.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agrirent.dto.RegisterRequestDto;
import com.agrirent.entity.User;
import com.agrirent.entity.Role;
import com.agrirent.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;

    public final PasswordEncoder passwordEncoder;  
    
    public void registerUser(RegisterRequestDto requestDto) {
        if (userRepository.findByPhone(requestDto.getPhone()).isPresent()){
            throw new RuntimeException("Phone number already exists");
        }
        else if (userRepository.findByEmail(requestDto.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .username(requestDto.getUsername())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .email(requestDto.getEmail())
                .phone(requestDto.getPhone())
                .role(Role.USER)
                .build();

        userRepository.save(user);
    }
}
