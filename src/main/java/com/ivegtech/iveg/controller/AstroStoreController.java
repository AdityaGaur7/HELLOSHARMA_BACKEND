package com.ivegtech.iveg.controller;

import com.ivegtech.iveg.entity.AstroStore;
import com.ivegtech.iveg.service.AstroStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astrostore")
public class AstroStoreController {

    @Autowired
    private AstroStoreService astroStoreService;

    // Get all AstroStore items
    @GetMapping
    public List<AstroStore> getAllAstroStores() {
        return astroStoreService.getAllAstroStores();
    }

    // Get a single AstroStore item by ID
    @GetMapping("/{id}")
    public ResponseEntity<AstroStore> getAstroStoreById(@PathVariable Long id) {
        return astroStoreService.getAstroStoreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new AstroStore item
    @PostMapping
    public ResponseEntity<AstroStore> createAstroStore(@RequestBody AstroStore astroStore) {
        AstroStore savedAstroStore = astroStoreService.addAstroStore(astroStore);
        return ResponseEntity.ok(savedAstroStore);
    }

    // Update an existing AstroStore item
    @PutMapping("/{id}")
    public ResponseEntity<AstroStore> updateAstroStore(
            @PathVariable Long id,
            @RequestBody AstroStore astroStoreDetails) {
        try {
            AstroStore updatedAstroStore = astroStoreService.updateAstroStore(id, astroStoreDetails);
            return ResponseEntity.ok(updatedAstroStore);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an AstroStore item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAstroStore(@PathVariable Long id) {
        try {
            astroStoreService.deleteAstroStore(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
