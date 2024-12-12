package com.unillanos.proyecto.File.controllers;

import com.unillanos.proyecto.File.dto.ResponseGeneric;
import com.unillanos.proyecto.File.service.soap.SoapClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class FuntionToken
{
  @Autowired
  SoapClientService soapClientService;

  @PostMapping("test")
  public String validateToken(){
    return "Validado token Puede Continuar";
  }

  @GetMapping("file-list")
  public ResponseEntity<ResponseGeneric> getFileList(){
    var response = soapClientService.getFileList();
   ResponseGeneric generic = new ResponseGeneric(true, "ok");
    generic.setAnswer(response);
    return ResponseEntity.ok(generic);
  }

  @GetMapping("uuid")
  public ResponseEntity<ResponseGeneric> getFileByUUID(@RequestParam("uuid") String uuid){
    var response = soapClientService.getFileUUID(uuid);
    ResponseGeneric generic = new ResponseGeneric(true, "ok");
    generic.setAnswer(response);
    return ResponseEntity.ok(generic);
  }
}
