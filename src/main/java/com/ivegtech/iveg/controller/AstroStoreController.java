package com.ivegtech.iveg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ivegtech.iveg.entity.AstroStore;
import com.ivegtech.iveg.service.AstroStoreService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astrostore")
public class AstroStoreController {

    @Autowired
    private AstroStoreService astroStoreService;

    @GetMapping
    public List<AstroStore> getAllProducts() {
        return astroStoreService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AstroStore> getProductById(@PathVariable Long id) {
        AstroStore product = astroStoreService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public AstroStore createProduct(@RequestBody AstroStore product) {
        return astroStoreService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AstroStore> updateProduct(@PathVariable Long id, @RequestBody AstroStore productDetails) {
        AstroStore updatedProduct = astroStoreService.updateProduct(id, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        astroStoreService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
