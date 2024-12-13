package com.unillanos.proyecto.File.controllers;

import com.unillanos.proyecto.File.dto.AuthRequest;
import com.unillanos.proyecto.File.dto.AuthResponse;
import com.unillanos.proyecto.File.dto.ResponseGeneric;
import com.unillanos.proyecto.File.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthController
{
  @Autowired
  private AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) throws IOException
  {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    System.out.println("Usuario " + auth.getPrincipal());
    System.out.println("Permisos " + auth.getAuthorities());
    System.out.println("autenticado " + auth.isAuthenticated());
    AuthRequest aut = new AuthRequest();
    aut.setUsername("unillanosProyectos");
    aut.setPassword("&12345&");
    return ResponseEntity.ok(authService.authenticate(aut));
  }

  @PostMapping("/register")
  public ResponseEntity<ResponseGeneric> generalToken(@RequestBody AuthRequest authRequest) throws IOException
  {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    System.out.println("Usuario " + auth.getPrincipal());
    System.out.println("Permisos " + auth.getAuthorities());
    System.out.println("autenticado " + auth.isAuthenticated());
    AuthRequest aut = new AuthRequest();
    aut.setUsername("unillanosProyectos");
    aut.setPassword("&12345&");
    return ResponseEntity.ok(authService.getToken(authRequest));
  }

}
