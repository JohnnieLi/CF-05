package ca.ucareer.computerfactory.core;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class JWT {

    @Value("${ucareer.jwt.expire-in-hour}")
    Long expireHours = 24L;

    @Value("${ucareer.jwt.token}")
    String plainSecret;

    //Encode plainsecret if plainsecret is provided
    private String generateEncodedSecret(String plainSecret) throws IllegalAccessException {
        if (StringUtils.isEmpty(plainSecret)){
            throw new IllegalAccessException("JWT secret cannot be null or emtpy");
        }
        return Base64.getEncoder().encodeToString(this.plainSecret.getBytes());
    }

    //Create json web token
    public String creatLoginToken(String username) throws IllegalAccessException {
        Date now = new Date();
        Long expireInMillis = TimeUnit.HOURS.toMillis(expireHours);
        Date expireAt = new Date(expireInMillis + now.getTime());
        String encodedSecret = generateEncodedSecret(this.plainSecret); //Call the generate function to get encoded string
        return Jwts.builder() //Setup the JWT claims
                .setId(UUID.randomUUID().toString())
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expireAt)
                .signWith(SignatureAlgorithm.HS256, encodedSecret)
                .compact();
    }

    //Validate login token
    public String verifyLoginToken(String token){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(plainSecret.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e){
            return null;
        }
    }
}
