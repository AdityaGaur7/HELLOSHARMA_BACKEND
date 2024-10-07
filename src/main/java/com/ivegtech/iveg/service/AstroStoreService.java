package com.ivegtech.iveg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivegtech.iveg.entity.AstroStore;
import com.ivegtech.iveg.repo.AstroStoreRepository;

import java.util.List;

@Service
public class AstroStoreService {

    @Autowired
    private AstroStoreRepository astroStoreRepository;

    public List<AstroStore> getAllProducts() {
        return astroStoreRepository.findAll();
    }

    public AstroStore getProductById(Long id) {
        return astroStoreRepository.findById(id).orElse(null);
    }

    public AstroStore createProduct(AstroStore product) {
        return astroStoreRepository.save(product);
    }

    public AstroStore updateProduct(Long id, AstroStore productDetails) {
        AstroStore product = getProductById(id);
        if (product != null) {
            product.setTitle(productDetails.getTitle());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            product.setImage(productDetails.getImage());
            product.setLink(productDetails.getLink());
            product.setTag(productDetails.getTag());
            return astroStoreRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        astroStoreRepository.deleteById(id);
    }
}
