package com.ivegtech.iveg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ivegtech.iveg.entity.Astrologer;
import com.ivegtech.iveg.service.AstrologerService;

import java.util.List;

@RestController
@RequestMapping("/api/astrologers")
public class AstrologerController {

    @Autowired
    private AstrologerService astrologerService;

    @GetMapping
    public List<Astrologer> getAllAstrologers() {
        return astrologerService.getAllAstrologers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Astrologer> getAstrologerById(@PathVariable Long id) {
        return astrologerService.getAstrologerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Astrologer addAstrologer(@RequestBody Astrologer astrologer) {
        return astrologerService.addAstrologer(astrologer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Astrologer> updateAstrologer(@PathVariable Long id, @RequestBody Astrologer astrologerDetails) {
        return ResponseEntity.ok(astrologerService.updateAstrologer(id, astrologerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstrologer(@PathVariable Long id) {
        astrologerService.deleteAstrologer(id);
        return ResponseEntity.noContent().build();
    }
}
