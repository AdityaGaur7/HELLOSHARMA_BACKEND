package com.ivegtech.iveg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivegtech.iveg.entity.Pooja;
import com.ivegtech.iveg.repo.PoojaRepository;

import java.util.List;

@Service
public class PoojaService {

    @Autowired
    private PoojaRepository poojaRepository;

    public List<Pooja> getAllPoojas() {
        return poojaRepository.findAll();
    }

    public Pooja getPoojaById(Long id) {
        return poojaRepository.findById(id).orElse(null);
    }

    public Pooja createPooja(Pooja pooja) {
        return poojaRepository.save(pooja);
    }

    public Pooja updatePooja(Long id, Pooja poojaDetails) {
        Pooja pooja = getPoojaById(id);
        if (pooja != null) {
            pooja.setName(poojaDetails.getName());
            pooja.setType(poojaDetails.getType());
            pooja.setDescription(poojaDetails.getDescription());
            pooja.setPrice(poojaDetails.getPrice());
            return poojaRepository.save(pooja);
        }
        return null;
    }

    public void deletePooja(Long id) {
        poojaRepository.deleteById(id);
    }
}
