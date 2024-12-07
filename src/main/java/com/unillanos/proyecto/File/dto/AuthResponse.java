package com.unillanos.proyecto.File.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
public class AuthResponse
{
  private String token;

  public AuthResponse(String token) {
    this.token = token;
  }

}
