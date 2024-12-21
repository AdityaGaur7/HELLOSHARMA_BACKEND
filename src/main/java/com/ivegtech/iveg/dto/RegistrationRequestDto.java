package com.ivegtech.iveg.dto;

public class RegistrationRequestDto {

	
	private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String role;
    
    
	
    public RegistrationRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistrationRequestDto(String email, String firstName, String lastName, String password, String phone,String role) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}
   
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
    
    
    
    
    
    
}
