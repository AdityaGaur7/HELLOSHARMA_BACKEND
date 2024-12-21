package com.ivegtech.iveg.dto;

import com.ivegtech.iveg.entity.Role;
import com.ivegtech.iveg.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {

    private User user;
    
    private Role role ;

    public MyUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public MyUserDetails(User user, Role role ) {
        this.user = user;
        this.role= role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // If user can have multiple roles, you can map them like below
        return Collections.singletonList(new SimpleGrantedAuthority(role.getRoleName()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();  // Can switch to phone if preferred
    }

    public String getEmail() {
        return user.getEmail();
    }

    public String getPhone() {
        return user.getPhone();
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // You can enhance this logic based on user expiration policies
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // You can add lock policies
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // You can set expiration policy for credentials if required
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    // Optional: Override toString, hashCode, and equals for MyUserDetails if needed
    @Override
    public String toString() {
        return "MyUserDetails{" +
               "email='" + user.getEmail() + '\'' +
               ", firstName='" + user.getFirstName() + '\'' +
               ", lastName='" + user.getLastName() + '\'' +
               ", phone='" + user.getPhone() + '\'' +
               '}';
    }

	
}
