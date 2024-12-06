package com.unillanos.proyecto.File.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest
{
  private String username;
  private String password;
}
