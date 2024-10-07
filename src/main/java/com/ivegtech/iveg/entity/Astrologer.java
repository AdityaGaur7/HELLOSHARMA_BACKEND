package com.ivegtech.iveg.entity;

import jakarta.persistence.*;

@Entity
public class Astrologer {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String expertise;
    private String languages;
    private String experience;
    private int orders;
    private String price;
    private double rating;
    private String status;
    private String imageUrl;

    // Constructors, Getters, and Setters
    public Astrologer() {}

    public Astrologer(String name, String expertise, String languages, String experience, int orders, String price, double rating, String status, String imageUrl) {
        this.name = name;
        this.expertise = expertise;
        this.languages = languages;
        this.experience = experience;
        this.orders = orders;
        this.price = price;
        this.rating = rating;
        this.status = status;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
}
