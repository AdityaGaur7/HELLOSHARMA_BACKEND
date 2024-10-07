package com.ivegtech.iveg.dto;

	public class JwtResponse {
	    private String jwt;
	    private String name;
	    private String email;
	    private String phone;

	    public JwtResponse(String jwt, String name, String email, String phone) {
	        this.jwt = jwt;
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	    }

	    public String getJwt() {
	        return jwt;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPhone() {
	        return phone;
	    }
	}


