package ca.ucareer.computerfactory.core;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Base64;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class JWT {

    @Value("${ucareer.jwt.token}")
    private String plainSecret = "LsjY79787hkk";

    @Value("${ucareer.jwt.expire-in-hour}")
    private Long expiration = 24L;

    private String superSecret(){
        return Base64.getEncoder()
                .encodeToString(this.plainSecret.getBytes());
    }

    public String createToken(String username){
        Date now = new Date();
        Date expiredAt = new Date(now.getTime()
                + TimeUnit.HOURS.toMillis(this.expiration));
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiredAt)
                .signWith(SignatureAlgorithm.HS256, superSecret())
                .compact();

    }

    public String verifyToken(String token) throws Exception{
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(superSecret())
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        }
        catch(Exception e){
            throw new Exception(e);
        }
    }


}
