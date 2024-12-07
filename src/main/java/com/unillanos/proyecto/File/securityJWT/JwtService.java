package com.unillanos.proyecto.File.securityJWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService
{
  private static final String SECRET_KEY = "G9VslAv+E6khUEkNUiXKMTiwO7bbQBgGo6bOAEGHlbk=";
  public String getToken(UserDetails user){
    return getToken(new HashMap<>(), user);
  }

  private String getToken(Map<String,Object> extraClaims, UserDetails user)
  {
    return Jwts.builder()
        .setClaims(extraClaims)
        .setSubject(user.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 100000*60*24))
        .signWith(getKey(), SignatureAlgorithm.HS256)
        .compact();
  }

  private Key getKey(){
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  public String getUserNameFromToken(String token)
  {
    return getClaim(token, Claims::getSubject);
  }

  private Claims getAllClaims(String token)
  {
    return Jwts.parserBuilder()
        .setSigningKey(getKey())
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public boolean isTokenValid(String token, UserDetails userDetails)
  {
    final String username = getUserNameFromToken(token);
    return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
  }

  public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
    final Claims claims = getAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Date getExpiration(String token){
    var dateToken = getClaim(token, Claims::getExpiration);;
    return dateToken;
  }

  private boolean isTokenExpired(String token){
    return getExpiration(token).before(new Date());
  }
}
