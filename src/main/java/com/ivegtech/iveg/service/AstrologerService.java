package com.ivegtech.iveg.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivegtech.iveg.entity.Astrologer;
import com.ivegtech.iveg.repo.AstrologerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AstrologerService {

    @Autowired
    private AstrologerRepository astrologerRepository;

    public List<Astrologer> getAllAstrologers() {
        return astrologerRepository.findAll();
    }

    public Optional<Astrologer> getAstrologerById(Long id) {
        return astrologerRepository.findById(id);
    }

    public Astrologer addAstrologer(Astrologer astrologer) {
        return astrologerRepository.save(astrologer);
    }

    public Astrologer updateAstrologer(Long id, Astrologer astrologerDetails) {
        Astrologer astrologer = astrologerRepository.findById(id).orElseThrow(() -> new RuntimeException("Astrologer not found"));
        astrologer.setName(astrologerDetails.getName());
        astrologer.setExpertise(astrologerDetails.getExpertise());
        astrologer.setLanguages(astrologerDetails.getLanguages());
        astrologer.setExperience(astrologerDetails.getExperience());
        astrologer.setOrders(astrologerDetails.getOrders());
        astrologer.setPrice(astrologerDetails.getPrice());
        astrologer.setRating(astrologerDetails.getRating());
        astrologer.setStatus(astrologerDetails.getStatus());
        astrologer.setImageUrl(astrologerDetails.getImageUrl());
        return astrologerRepository.save(astrologer);
    }

    public void deleteAstrologer(Long id) {
        Astrologer astrologer = astrologerRepository.findById(id).orElseThrow(() -> new RuntimeException("Astrologer not found"));
        astrologerRepository.delete(astrologer);
    }
}
