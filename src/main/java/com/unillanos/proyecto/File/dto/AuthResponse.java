package com.unillanos.proyecto.File.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponse
{
  private String token;

  public AuthResponse(String token) {
    this.token = token;
  }

}
