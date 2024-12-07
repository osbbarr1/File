/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.proyecto.File.integrity.controller;

import com.unillanos.proyecto.File.integrity.service.FileIntegrityService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author andre
 */
@RestController
@RequestMapping("/api/integrity")
public class FileIntegrityController {

    @Autowired
    private FileIntegrityService fileIntegrityService;

    @GetMapping()
    public String getMethodName() {
        return "OK";
    }
    

    @PostMapping("/verify")
    public ResponseEntity<String> verifyFileIntegrity(@RequestBody Map<String, String> payload) {
        try {
            // Extrae el string binario del JSON
            String filedata = payload.get("filedata");

            // Llama al servicio con el string binario
            String result = fileIntegrityService.verifyIntegrity(filedata);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
