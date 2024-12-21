package com.ivegtech.iveg.dto;

public class AstrologerUpdateRequestDto {
    private String expertise;
    private String languages;
    private String experience;
    private String price;
    private String status;
    private String imageUrl;

    // Getters and Setters
    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
