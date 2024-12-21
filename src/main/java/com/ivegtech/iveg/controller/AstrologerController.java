package com.ivegtech.iveg.controller;

import com.ivegtech.iveg.dto.AstrologerUpdateRequestDto;
import com.ivegtech.iveg.entity.User;
import com.ivegtech.iveg.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astrologers")
public class AstrologerController {

    private final UserService userService;

    public AstrologerController(UserService userService) {
        this.userService = userService;
    }

    // Get all astrologers
    @GetMapping
    public ResponseEntity<List<User>> getAllAstrologers() {
        List<User> astrologers = userService.getAstrologersByRoleId(3L); // Fetch astrologers by role ID
        return ResponseEntity.ok(astrologers);
    }
 

    // Update astrologer details
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAstrologerDetails(
            @PathVariable Long id,
            @RequestBody AstrologerUpdateRequestDto updateRequest) {
        try {
            userService.updateAstrologerDetails(id, updateRequest);
            return ResponseEntity.ok("Astrologer details updated successfully.");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An unexpected error occurred.");
        }
    }
}
