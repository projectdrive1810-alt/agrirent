package com.agrirent.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String email){
        return Jwts.builder()
                    .subject(email)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                    .signWith(Keys.hmacShaKeyFor(secret.getBytes()),
                        Jwts.SIG.HS256)
                    .compact();
    }

    public String extractEmail(String token) {
    return Jwts.parser()
            .verifyWith(
                    Keys.hmacShaKeyFor(secret.getBytes())
            )
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
}
    public boolean validateToken(String token) {
    try {
        Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseSignedClaims(token);

        return true;
    } catch (Exception e) {
        return false;
    }
}
}
