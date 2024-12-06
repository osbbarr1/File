package com.unillanos.proyecto.File.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class FuntionToken
{
  @PostMapping("test")
  public String validateToken(){
    return "Validado token Puede Continuar";
  }
}
