package com.ivegtech.iveg.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private Key secretKey;

    // Inject the base64-encoded key from application.properties
    @Value("${jwt.secret.key}")
    public void setSecretKey(String base64Key) {
        // Decode the Base64-encoded key and generate the signing key
        byte[] keyBytes = Base64.getDecoder().decode(base64Key);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    
    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities) {
        // Convert authorities (GrantedAuthority objects) to a comma-separated string of role names
        String roles = authorities.stream()
                                  .map(GrantedAuthority::getAuthority)
                                  .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(username)
                .claim("role", roles)  // Add roles as a comma-separated string
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // Token validity: 10 hours
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }
}
