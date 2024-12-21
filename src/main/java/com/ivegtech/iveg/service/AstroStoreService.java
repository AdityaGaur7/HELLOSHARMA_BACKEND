package com.ivegtech.iveg.service;

import com.ivegtech.iveg.entity.AstroStore;
import com.ivegtech.iveg.repo.AstroStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AstroStoreService {

    @Autowired
    private AstroStoreRepository astroStoreRepository;

    // Retrieve all AstroStore items
    public List<AstroStore> getAllAstroStores() {
        return astroStoreRepository.findAll();
    }

    // Retrieve an AstroStore item by ID
    public Optional<AstroStore> getAstroStoreById(Long id) {
        return astroStoreRepository.findById(id);
    }

    // Add a new AstroStore item
    public AstroStore addAstroStore(AstroStore astroStore) {
        return astroStoreRepository.save(astroStore);
    }

    // Update an existing AstroStore item
    public AstroStore updateAstroStore(Long id, AstroStore astroStoreDetails) {
        return astroStoreRepository.findById(id).map(astroStore -> {
            astroStore.setTitle(astroStoreDetails.getTitle());
            astroStore.setDescription(astroStoreDetails.getDescription());
            astroStore.setPrice(astroStoreDetails.getPrice());
            astroStore.setImage(astroStoreDetails.getImage());
            astroStore.setLink(astroStoreDetails.getLink());
            astroStore.setTag(astroStoreDetails.getTag());
            return astroStoreRepository.save(astroStore);
        }).orElseThrow(() -> new RuntimeException("AstroStore with ID " + id + " not found"));
    }

    // Delete an AstroStore item by ID
    public void deleteAstroStore(Long id) {
        if (!astroStoreRepository.existsById(id)) {
            throw new RuntimeException("AstroStore with ID " + id + " not found");
        }
        astroStoreRepository.deleteById(id);
    }
}
