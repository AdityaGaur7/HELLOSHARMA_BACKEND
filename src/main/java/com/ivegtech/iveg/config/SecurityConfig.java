package com.ivegtech.iveg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ivegtech.iveg.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService customUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(UserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { http .csrf().disable() // Disable CSRF for API-based
	 * authentication .authorizeHttpRequests()
	 * .requestMatchers("/api/v1/auth/register", "/api/v1/auth/login",
	 * "/api/v1/poojas", "/api/v1/poojas/{id}", "/api/v1/astrologers",
	 * "/api/v1/astrostore", "/chat-websocket-native").permitAll() // Allow public
	 * access .anyRequest().authenticated() // Authenticate all other requests
	 * .and() .sessionManagement()
	 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session
	 * management .and() .addFilterBefore(jwtRequestFilter,
	 * UsernamePasswordAuthenticationFilter.class) // Apply JWT filter .cors(); //
	 * Enable CORS for WebSocket support
	 * 
	 * return http.build(); }
	 */
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for API-based authentication
            .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/register", "/api/v1/auth/login",
                                 "/api/v1/poojas", "/api/v1/poojas/{id}",
                                 "/api/v1/astrologers", "/api/v1/astrostore", 
                                 "/chat-websocket-native/**").permitAll() // Allow public access
                .requestMatchers(HttpMethod.OPTIONS, "/chat-websocket-native/**").permitAll() // Pre-flight
                .anyRequest().authenticated() // Authenticate all other requests
            .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session management
            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class) // Apply JWT filter
            .cors(); // Enable CORS for WebSocket support

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .userDetailsService(customUserDetailsService)
                   .passwordEncoder(passwordEncoder())
                   .and()
                   .build();
    }
}
