package com.ivegtech.iveg.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_details", schema = "public")
public class User implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_details_seq")
    @SequenceGenerator(name = "user_details_seq", sequenceName = "user_details_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "email", length = 280, nullable = false)
    private String email;

    @Column(name = "first_name", length = 70, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 70)
    private String lastName;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "phone", length = 255, nullable = false)
    private String phone;

    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // Astrologer-specific attributes
    private String expertise;
    private String languages;
    private String experience;
    private String  orders;
    private String price;
    private String  rating;
    private String status;
    private String imageUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<ChatMessage> sentMessages;

    @JsonIgnore
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<ChatMessage> receivedMessages;
    
    // Constructors, Getters, Setters, and toString() methods

    public User() {}

    public User(String email, String firstName, String lastName, String password, String phone, boolean isEnabled, Role role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.isEnabled = isEnabled;
        this.role = role;
    }

    // Getters and Setters for common fields

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Getters and Setters for Astrologer-specific attributes
    // (Only used if role == Role.ASTROLOGER)

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

    public String  getOrders() {
        return orders;
    }

    public void setOrders(String  orders) {
        this.orders = orders;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String  getRating() {
        return rating;
    }

    public void setRating(String  rating) {
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

    public List<ChatMessage> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<ChatMessage> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<ChatMessage> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<ChatMessage> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }
}
