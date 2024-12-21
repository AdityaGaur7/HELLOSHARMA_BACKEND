package com.ivegtech.iveg.controller;

import com.ivegtech.iveg.entity.Pooja;
import com.ivegtech.iveg.service.PoojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/poojas")
public class PoojaController {

    private final PoojaService poojaService;

    // Constructor-based dependency injection
    @Autowired
    public PoojaController(PoojaService poojaService) {
        this.poojaService = poojaService;
    }

    // Get all poojas
    @GetMapping
    public ResponseEntity<List<Pooja>> getAllPoojas() {
        List<Pooja> poojas = poojaService.getAllPoojas();
        if (poojas.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no content found
        }
        return ResponseEntity.ok(poojas); // Return 200 OK if content is found
    }

    // Get pooja by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pooja> getPoojaById(@PathVariable("id") Long id) {
        Optional<Pooja> pooja = Optional.ofNullable(poojaService.getPoojaById(id));
        return pooja.map(ResponseEntity::ok) // Return 200 OK if pooja found
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()); // Return 404 if not found
    }

    // Create new pooja
    @PostMapping
    public ResponseEntity<Pooja> createPooja(@RequestBody Pooja pooja) {
        Pooja createdPooja = poojaService.createPooja(pooja);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPooja); // Return 201 on successful creation
    }

    // Update existing pooja
    @PutMapping("/{id}")
    public ResponseEntity<Pooja> updatePooja(@PathVariable("id") Long id, @RequestBody Pooja pooja) {
        Pooja updatedPooja = poojaService.updatePooja(id, pooja);
        return updatedPooja != null ? ResponseEntity.ok(updatedPooja) // Return 200 if pooja updated
                                    : ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if pooja not found
    }

    // Delete pooja
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePooja(@PathVariable("id") Long id) {
        poojaService.deletePooja(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content after successful deletion
    }
}
