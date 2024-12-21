package com.ivegtech.iveg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ivegtech.iveg.dto.AstrologerUpdateRequestDto;
import com.ivegtech.iveg.entity.User;
import com.ivegtech.iveg.repo.UserRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepo UserRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo UserRepo, PasswordEncoder passwordEncoder) {
        this.UserRepo = UserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // User registration logic
    public String registerUser(User userDetails) {
        // Check if user with the same email exists
        if (UserRepo.findByEmail(userDetails.getEmail()).isPresent()) {
            throw new IllegalStateException("Email is already registered!");
        }

        // Check if user with the same phone number exists
        if (UserRepo.findByPhone(userDetails.getPhone()).isPresent()) {
            throw new IllegalStateException("Phone number is already registered!");
        }

        // Encode the password before saving
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));

        // Save the new user if no email or phone number conflict
        UserRepo.save(userDetails);
        return "User registered successfully!";
    }
    // Fetch astrologers by role ID
    public List<User> getAstrologersByRoleId(Long roleId) {
        return UserRepo.findByRoleId(roleId);
    }

    // Update astrologer details
    public void updateAstrologerDetails(Long id, AstrologerUpdateRequestDto updateRequest) {
        User astrologer = UserRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Astrologer not found with ID: " + id));

        if (!astrologer.getRole().getId().equals(3L)) {
            throw new IllegalStateException("User is not an astrologer.");
        }

        // Update fields
        if (updateRequest.getExpertise() != null) astrologer.setExpertise(updateRequest.getExpertise());
        if (updateRequest.getLanguages() != null) astrologer.setLanguages(updateRequest.getLanguages());
        if (updateRequest.getExperience() != null) astrologer.setExperience(updateRequest.getExperience());
        if (updateRequest.getPrice() != null) astrologer.setPrice(updateRequest.getPrice());
        if (updateRequest.getStatus() != null) astrologer.setStatus(updateRequest.getStatus());
        if (updateRequest.getImageUrl() != null) astrologer.setImageUrl(updateRequest.getImageUrl());

        UserRepo.save(astrologer);
    }
   
}
