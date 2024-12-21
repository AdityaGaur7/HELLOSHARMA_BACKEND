package com.ivegtech.iveg.service;

import com.ivegtech.iveg.entity.Pooja;
import com.ivegtech.iveg.repo.PoojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoojaService {

    // Autowiring the PoojaRepository
    @Autowired
    private final PoojaRepository poojaRepository;

    // Constructor-based injection for better clarity and immutability
    public PoojaService(PoojaRepository poojaRepository) {
        this.poojaRepository = poojaRepository;
    }

    // Get all Poojas
    public List<Pooja> getAllPoojas() {
        return poojaRepository.findAll();
    }

    // Get Pooja by ID
    public Pooja getPoojaById(Long id) {
        Optional<Pooja> pooja = poojaRepository.findById(id);
        return pooja.orElse(null); // Return null if not found
    }

    // Create a new Pooja
    public Pooja createPooja(Pooja pooja) {
        return poojaRepository.save(pooja);
    }

    // Update an existing Pooja
    public Pooja updatePooja(Long id, Pooja pooja) {
        if (poojaRepository.existsById(id)) {
            pooja.setId(id); // Ensure ID is set for update
            return poojaRepository.save(pooja);
        }
        return null; // Return null if the Pooja does not exist
    }

    // Delete a Pooja by ID
    public void deletePooja(Long id) {
        poojaRepository.deleteById(id);
    }
}
