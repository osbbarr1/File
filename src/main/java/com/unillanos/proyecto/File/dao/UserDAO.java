package com.unillanos.proyecto.File.dao;

import com.unillanos.proyecto.File.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO
{
  public User findUserByUsername(String username) {
    if ("unillanosProyectos".equals(username)) {
      return new User("unillanosProyectos", "&12345&");
    }
    return null;
  }
}
