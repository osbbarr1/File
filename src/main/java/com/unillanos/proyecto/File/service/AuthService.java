package com.unillanos.proyecto.File.service;

import com.unillanos.proyecto.File.dao.UserDAO;
import com.unillanos.proyecto.File.dto.AuthRequest;
import com.unillanos.proyecto.File.dto.AuthResponse;
import com.unillanos.proyecto.File.model.User;
import com.unillanos.proyecto.File.securityJWT.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService
{
  @Autowired
  private UserDAO userDAO;

  @Autowired
  private final JwtService jwtService;

  public AuthResponse authenticate(AuthRequest authRequest) throws IOException
  {
    User user = userDAO.findUserByUsername(authRequest.getUsername());
    if (user == null || !user.getPassword().equals(authRequest.getPassword())) {
      throw new RuntimeException("Invalid username or password");
    }

    String token = "HOLA MUNDO";
    return new AuthResponse(token);
  }

  public AuthResponse getToken(AuthRequest authRequest) throws IOException
  {
    User user = userDAO.findUserByUsername(authRequest.getUsername());
    if (user == null || !user.getPassword().equals(authRequest.getPassword())) {
      throw new RuntimeException("Invalid username or password");
    }
    return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
  }
}
