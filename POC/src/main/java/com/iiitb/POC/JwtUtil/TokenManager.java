package com.iiitb.POC.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class TokenManager implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7008375124389347049L; public static final long TOKEN_VALIDITY = 10 * 60 * 60;
    //@Value("${secret}")
    private static String jwtSecret = "somethingwrongwiththethingsgoingarounddidntexpectmyselftobecaughtupwiththingslikethisbutitisnotasificouldhavedonethongsdiffernetlyastheysayifitismeanttobeitwillbe";
    private Map<String, Object> claims1;
    public String generateJwtToken(String username,String pass,String age,String father_name) {
        Map<String, Object> claims = new HashMap<>();
        //String encodedString = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
        claims1 = new HashMap<>();
        claims1.put("username", username);
        claims1.put("pass", pass);
        claims1.put("age", age);
        claims1.put("fathername", father_name);
        return Jwts.builder().setClaims(claims1)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        /*return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512, encodedString ).compact();*/
    }
    public String generateJwtToken1(String username) {
        Map<String, Object> claims2 = new HashMap<>();
        //String encodedString = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
        String father_name= (String) claims1.get("fathername");
        claims2.put("username", username);
        claims2.put("fathername", father_name);
        return Jwts.builder().setClaims(claims2)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        /*return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512, encodedString ).compact();*/
    }
    public String generateJwtToken2(String username) {
        Map<String, Object> claims2 = new HashMap<>();
        //String encodedString = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
        String age= (String) claims1.get("age");
        claims2.put("username", username);
        claims2.put("age", age);
        return Jwts.builder().setClaims(claims2)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
        /*return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY*1000))
                .signWith(SignatureAlgorithm.HS512, encodedString ).compact();*/
    }
    public Boolean validateJwtToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        Boolean isTokenExpired = claims.getExpiration().before(new Date());
        return (username.equals(userDetails.getUsername()) && !isTokenExpired);
    }
    public String getUsernameFromToken(String token) {
//        String encodedString = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
        final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}