package learn.configurations.Security.JWTAuth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JWTService {

    private static final String SECRET_KEY = "HelloThisLearningProcessOfJWTToken";
    private static final long EXPIRY = 10 * 60 * 1000;

    /*
    This takes secret key and derives a Key Object which is suitable for HMAC-SHA signing (HS256, HS512, etc..)
    The returned Key what you will pass to the signWith(...) while generating JWT token
     */
     private Key getSignKey(){
         return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
     }

     /*
     this generates the token,
     token contains username, claims, issuedAt, expiry of the token as encrypted string
     with signature of signAlgorithm.HS256
      */
     public String generateToken(UserDetails userDetails){
         /*
         If any authorities are there of the logged User we set them as claims to JWT token
          */
         Map<String, Object> claims = new HashMap<>();
         claims.put("roles", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

         return Jwts.builder()
                 .setClaims(claims)
                 .setSubject(userDetails.getUsername())
                 .setIssuedAt(new Date())
                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRY))
                 .signWith(getSignKey(), SignatureAlgorithm.HS256)
                 .compact();  // return String value, compact method returns String value
     }

     public String extractUsername(String token){
         return Jwts.parserBuilder().setSigningKey(getSignKey()).build()
                 .parseClaimsJws(token).getBody().getSubject();
     }

     public boolean isTokenValid(String token, UserDetails userDetails){
         String userName = extractUsername(token);
         return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
     }


     private boolean isTokenExpired(String token){
         Date expiry = Jwts.parserBuilder().setSigningKey(getSignKey()).build()
                 .parseClaimsJwt(token).getBody().getExpiration();
         return expiry.before(new Date());
     }


}
