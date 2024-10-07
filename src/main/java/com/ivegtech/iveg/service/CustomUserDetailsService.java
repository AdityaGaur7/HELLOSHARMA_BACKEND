package com.ivegtech.iveg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ivegtech.iveg.dto.MyUserDetails;
import com.ivegtech.iveg.entity.User;
import com.ivegtech.iveg.repo.UserRepo;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Try finding the user by email or phone number
        Optional<User> user = userRepo.findByEmail(username);
        
        if (user.isEmpty()) {
            user = userRepo.findByPhone(username);
        }

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email or phone number: " + username);
        }

        return new MyUserDetails(user.get());
    }
}