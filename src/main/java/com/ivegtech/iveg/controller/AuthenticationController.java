package com.ivegtech.iveg.controller;

import com.ivegtech.iveg.dto.JwtResponse;
import com.ivegtech.iveg.dto.LoginRequest;
import com.ivegtech.iveg.dto.MyUserDetails;
import com.ivegtech.iveg.entity.User;
import com.ivegtech.iveg.util.JwtUtil;
import com.ivegtech.iveg.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*") 
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid username or password", e);
        }

        // Load user details from your custom user details service
       // final UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        
        MyUserDetails userDetails = (MyUserDetails) customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername(),userDetails.getAuthorities());

     
        String username = userDetails.getFirstName()+ " " + userDetails.getLastName();
        String email = userDetails.getEmail();
        String phone = userDetails.getPhone();

        // Return JWT token along with user info (username, email, phone)
        return ResponseEntity.ok(new JwtResponse(jwt, username, email, phone));
    }
}
