package com.unillanos.proyecto.File.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class User
{
  private String username;
  private String password;

  public User(String userName, String password)
  {
    this.username = userName;
    this.password = password;
  }
}
