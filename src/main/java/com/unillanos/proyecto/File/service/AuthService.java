package com.unillanos.proyecto.File.service;

import com.unillanos.proyecto.File.dao.UserDAO;
import com.unillanos.proyecto.File.dto.AuthRequest;
import com.unillanos.proyecto.File.dto.AuthResponse;
import com.unillanos.proyecto.File.model.User;
import com.unillanos.proyecto.File.security.jwt.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService
{
  @Autowired
  private UserDAO userDAO;

  @Autowired
  private JWTService jwtService;

  @Autowired
  private AuthenticationManager authenticationManager;

  public AuthResponse authenticate(AuthRequest authRequest) throws IOException
  {
    User user = userDAO.findUserByUsername(authRequest.getUsername());
    if (user == null || !user.getPassword().equals(authRequest.getPassword())) {
      throw new RuntimeException("Invalid username or password");
    }

    Authentication auth = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

    String token = jwtService.create(auth);
    return new AuthResponse(token);
  }
}
