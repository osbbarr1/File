package com.unillanos.proyecto.File.controllers;

import com.unillanos.proyecto.File.dto.AuthRequest;
import com.unillanos.proyecto.File.dto.AuthResponse;
import com.unillanos.proyecto.File.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController
{
  @Autowired
  private AuthService authService;

  @PostMapping("/login")
  public AuthResponse login(@RequestBody AuthRequest authRequest) throws IOException
  {
    return authService.authenticate(authRequest);
  }

}
