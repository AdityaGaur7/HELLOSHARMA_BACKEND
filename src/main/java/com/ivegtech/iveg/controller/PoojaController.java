package com.ivegtech.iveg.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ivegtech.iveg.entity.Pooja;
import com.ivegtech.iveg.service.PoojaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/poojas")
public class PoojaController {

    @Autowired
    private PoojaService poojaService;

    @GetMapping
    public List<Pooja> getAllPoojas() {
        return poojaService.getAllPoojas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pooja> getPoojaById(@PathVariable Long id) {
        Pooja pooja = poojaService.getPoojaById(id);
        return ResponseEntity.ok(pooja);
    }

    @PostMapping
    public Pooja createPooja(@RequestBody Pooja pooja) {
        return poojaService.createPooja(pooja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pooja> updatePooja(@PathVariable Long id, @RequestBody Pooja poojaDetails) {
        Pooja updatedPooja = poojaService.updatePooja(id, poojaDetails);
        return ResponseEntity.ok(updatedPooja);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePooja(@PathVariable Long id) {
        poojaService.deletePooja(id);
        return ResponseEntity.noContent().build();
    }
}
