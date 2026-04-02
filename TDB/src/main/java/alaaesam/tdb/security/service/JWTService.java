package alaaesam.tdb.security.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JWTService {
    @Value("${spring.security.private}")
    private String secretKey ;

    @Value("${spring.security.expiration}")
    private long jwtExpiration;


    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }

    public String generateToken(String userName,Map<String, Object> claims){
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .and()
                .signWith(getSignInKey(),Jwts.SIG.HS256)
                .compact();
    }

    public <T> T extractClaim(String token, Function<Claims,T> claimResolver){
        final Claims claims = extractAllClailm(token);
        return claimResolver.apply(claims);
    }

    public boolean validateToken(String token, UserDetails userDetails){
        final String userName=extractUserName(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Claims extractAllClailm(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

}
