//package com.ivegtech.iveg.util;
//
//import io.jsonwebtoken.security.Keys;
//import java.security.Key;
//import java.util.Base64;
//
//public class KeyGeneratorUtil {
//    public static void main(String[] args) {
//        // Generate a secure random 256-bit key
//        Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
//        
//        // Encode the key as a Base64 string
//        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
//        
//        System.out.println("Generated Key: " + base64Key);
//    }
//}