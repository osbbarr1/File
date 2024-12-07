package com.unillanos.proyecto.File.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Getter
@Setter
public class User implements UserDetails
{
  private String username;
  private String password;

  public User(String userName, String password)
  {
    this.username = userName;
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities()
  {
    return null;
  }

  @Override
  public boolean isAccountNonExpired()
  {
    return UserDetails.super.isAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return UserDetails.super.isAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return UserDetails.super.isCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled()
  {
    return UserDetails.super.isEnabled();
  }
}
