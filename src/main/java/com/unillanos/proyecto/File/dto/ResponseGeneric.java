package com.unillanos.proyecto.File.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGeneric
{
  private boolean success = false;
  private String message;
  private Object answer;
  public ResponseGeneric(boolean success, String message){
    this.success = success;
    this.message = message;
  }
}
