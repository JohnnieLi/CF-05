package ca.ucareer.computerfactory.core;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;



@Service
public class JWT {
    @Value("${ucareer.jwt.expire-in-hour}")
    private Long expireHours = 24L;

    @Value("${ucareer.jwt.token}")
    private String plainSecret;


    private String generateEncodedSecret(String plainSecret) {
        if (plainSecret != null) {
            return Base64
                    .getEncoder()
                    .encodeToString(this.plainSecret.getBytes());
        } else {
            return "JWT secret cannot be null or empty.";
        }
    }

    public String creatLoginToken(String username) {
        Date now = new Date();
        Long expireInMillis = TimeUnit.HOURS.toMillis(expireHours);
        Date expiredAt = new Date(now.getTime() + expireInMillis);
        String encodedSecret = generateEncodedSecret(this.plainSecret);
        //return "";
        return Jwts.builder().setId(UUID.randomUUID().toString())
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiredAt)
                .signWith(SignatureAlgorithm.HS256, encodedSecret)
                .compact();
    }

    public String verifyLoginToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(plainSecret.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }

    }

}
