package com.scp.foundation.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "votre_clé_secrète_qui_est_asymétrique"; // Doit être assez long et sécurisé.
    private Key key;

    public JwtUtil() {
        // Crée une clé secrète à partir de la chaîne spécifiée
        key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Méthode pour générer un JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 heure d'expiration
                .signWith(key, SignatureAlgorithm.HS256) // Utilisation de la clé secrète et de l'algorithme HS256
                .compact();
    }

    // Méthode pour valider un JWT
    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // Extraire le nom d'utilisateur du JWT
    public String extractUsername(String token) {
        return Jwts.parserBuilder() // La version recommandée
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Vérifier si le token est expiré
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extraire la date d'expiration du token
    private Date extractExpiration(String token) {
        return Jwts.parserBuilder() // La version recommandée
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
