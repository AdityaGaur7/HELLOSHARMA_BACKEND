package com.ivegtech.iveg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivegtech.iveg.dto.RegistrationRequestDto;
import com.ivegtech.iveg.entity.User;
import com.ivegtech.iveg.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*") 
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequestDto registrationRequest) {
        User userDetails = new User();
        userDetails.setEmail(registrationRequest.getEmail());
        userDetails.setFirstName(registrationRequest.getFirstName());
        userDetails.setLastName(registrationRequest.getLastName());
        userDetails.setPassword(registrationRequest.getPassword()); 
        userDetails.setPhone(registrationRequest.getPhone());
        userDetails.setEnabled(true);

        String result = userService.registerUser(userDetails);

        return ResponseEntity.ok(result);
    }
}