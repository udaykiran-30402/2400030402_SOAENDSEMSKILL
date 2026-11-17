package com.example.demo;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private String secret =
        "MySecretKeyForJWTGeneration123456789012";

    public String generateToken(String username) {

        SecretKey key = Keys.hmacShaKeyFor(
            secret.getBytes()
        );

        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(
                System.currentTimeMillis() + 3600000
            ))
            .signWith(key)
            .compact();
    }
}
