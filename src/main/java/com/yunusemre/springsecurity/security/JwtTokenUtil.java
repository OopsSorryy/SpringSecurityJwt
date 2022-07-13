package com.yunusemre.springsecurity.security;


import com.yunusemre.springsecurity.user.User;
import io.jsonwebtoken.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; //24h

    @Value("${app.jwt.secret}")
    private String secretKey;

    public String generateAccessToken(User user) {

        return Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + EXPIRE_DURATION *1000))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;

        } catch (ExpiredJwtException e) {
            LOGGER.error("JWT expired", e);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Token is null", e);
        } catch (UnsupportedJwtException e) {
            LOGGER.error("JWT is not supported", e);
        } catch (MalformedJwtException e) {
            LOGGER.error("JWT is invalid", e);
        } catch (SignatureException e) {
            LOGGER.error("Signature validation failed", e);

        }
        return false;
    }
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
