package com.ivegtech.iveg.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivegtech.iveg.dto.RegistrationRequestDto;
import com.ivegtech.iveg.entity.Role;
import com.ivegtech.iveg.entity.User;
import com.ivegtech.iveg.repo.RoleRepository;
import com.ivegtech.iveg.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class UserRegistrationController {

    private final UserService userService;
    
    private final RoleRepository roleRepository;


    public UserRegistrationController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository=roleRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Validated @RequestBody RegistrationRequestDto registrationRequest) {
        try {
            // Map RegistrationRequestDto to User entity
            User userDetails = mapToUserEntity(registrationRequest);

            // Call the service to register the user
            String result = userService.registerUser(userDetails);
            return ResponseEntity.ok(result);

        } catch (IllegalStateException e) {
            // Handle duplicate email/phone number cases or other registration issues
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Handle unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    private User mapToUserEntity(RegistrationRequestDto registrationRequest) {
        
    	User user = new User();
    	  Role userRole = roleRepository.findByRoleName("USER")
    	            .orElseThrow(() -> new IllegalStateException("Role 'USER' not found"));

        user.setEmail(registrationRequest.getEmail());
        user.setFirstName(registrationRequest.getFirstName());
        user.setLastName(registrationRequest.getLastName());
        user.setPassword(registrationRequest.getPassword());
        user.setPhone(registrationRequest.getPhone());
        user.setRole(userRole);
        user.setEnabled(true);

        // Set additional fields here if the updated model has new fields
        // Example:
        // user.setAddress(registrationRequest.getAddress());
        // user.setDateOfBirth(registrationRequest.getDateOfBirth());

        return user;
    }

    // Optional: If you have more controllers, you can centralize this exception handler in a @ControllerAdvice class.
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
