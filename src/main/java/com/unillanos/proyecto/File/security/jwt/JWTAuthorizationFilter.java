package com.unillanos.proyecto.File.security.jwt;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.unillanos.proyecto.File.security.jwt.service.JWTService;
import com.unillanos.proyecto.File.security.jwt.service.JWTServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

  private JWTService jwtServices;

  public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTService  jwtServices) {
    super(authenticationManager);
    this.jwtServices = jwtServices;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    String header = request.getHeader(JWTServiceImpl.HEADER_STRING);
    if (!requiresAuthentication(header)) {
      chain.doFilter(request, response);
      return;
    }

    UsernamePasswordAuthenticationToken authentication = null;


    if(jwtServices.validate(header)) {
      authentication = new UsernamePasswordAuthenticationToken(jwtServices.getUsername(header),null,jwtServices.getRoles(header));
    }

    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(request, response);

  }

  protected  boolean requiresAuthentication(String header) {
    if(header == null || !header.startsWith(JWTServiceImpl.TOKEN_PREFIX)) {
      return false;
    }
    return true;
  }
}
