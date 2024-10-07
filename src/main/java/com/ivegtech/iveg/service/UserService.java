package com.ivegtech.iveg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ivegtech.iveg.entity.User;
import com.ivegtech.iveg.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userDetailsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Use the password encoder

    public String registerUser(User userDetails) {
        // Check if user with the same email exists
        if (userDetailsRepository.findByEmail(userDetails.getEmail()).isPresent()) {
            return "Email is already registered!";
        }

        // Check if user with the same phone number exists
        if (userDetailsRepository.findByPhone(userDetails.getPhone()).isPresent()) {
            return "Phone number is already registered!";
        }

        // Encode the password before saving
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));

        // Save the new user if no email or phone number conflict
        userDetailsRepository.save(userDetails);
        return "User registered successfully!";
    }
}
