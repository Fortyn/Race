package application.security;

import application.repositories.UserRepository;
import db.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class JWTProvider {

    /**
     * THIS IS NOT A SECURE PRACTICE! For simplicity, we are storing a static key here. Ideally, in a
     * microservices environment, this key would be kept on a config-server.
     */

    private String secretKey = "secret";

    private long validityInMilliseconds = 3600000; // 1h

    private String headerName = "Authorization";

    private String prefix = "Bearer ";

    private final UserRepository userRepository;

    public JWTProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username) {
        if(!userRepository.existsByLogin(username)) throw new RuntimeException("the login is not available");
        User user = userRepository.findByLogin(username);
        Claims claims = Jwts.claims()
                .setSubject(username)
                .setId(String.valueOf(user.getId()));
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS256, secretKey)//
                .compact();
    }

    public Authentication getAuthentication(String token) {
        String id = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getId();
        User user = userRepository.findById(Long.valueOf(id)).orElseThrow();
        return new UsernamePasswordAuthenticationToken(user, "", Collections.emptySet());
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader(headerName);
        if (bearerToken != null && bearerToken.startsWith(prefix)) {
            return bearerToken.substring(prefix.length());
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Expired or invalid JWT token");
        }
    }

}
