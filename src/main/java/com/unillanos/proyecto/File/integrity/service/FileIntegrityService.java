/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.proyecto.File.integrity.service;

import com.unillanos.proyecto.File.integrity.entity.FileIntegrityEntity;
import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unillanos.proyecto.File.integrity.repository.FileIntegrityRepository;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andre
 */

@Service
public class FileIntegrityService {

    @Autowired
    private FileIntegrityRepository fileRepository;

    public Map<String, Object> verifyIntegrity(String filedata) throws Exception {
        // Convierte el string binario a byte[]
        byte[] fileBytes = binaryStringToByteArray(filedata);

        // Calcula el hash del archivo recibido
        String fileHash = calculateSHA256(fileBytes);

        // Busca el hash en la base de datos
        List<FileIntegrityEntity> matchingFiles = fileRepository.findByHash(fileHash);

        // Respuesta según el caso
        if (matchingFiles.isEmpty()) {
            return Map.of(
                "status", "invalid",
                "message", "El archivo no es original."
            );
        } else if (matchingFiles.size() > 1) {
            // Incluye el id, namefile y metadata en la respuesta
            List fileList = matchingFiles.stream()
                .map(file -> Map.of(
                    "id", file.getId(),
                    "namefile", file.getNamefile(),
                    "metadata", file.getMetadata() 
                ))
                .toList();

            return Map.of(
                "status", "multiple",
                "message", "Existen múltiples archivos con contenido idéntico.",
                "files", fileList
            );
        } else {
            return Map.of(
                "status", "valid",
                "message", "El archivo es válido."
            );
        }
    }


    private String calculateSHA256(byte[] fileBytes) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(fileBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private byte[] binaryStringToByteArray(String binaryString) {
        int byteLength = binaryString.length() / 8; 
        byte[] byteArray = new byte[byteLength];
        for (int i = 0; i < byteLength; i++) {
            int startIndex = i * 8;
            int endIndex = startIndex + 8;
            byteArray[i] = (byte) Integer.parseInt(binaryString.substring(startIndex, endIndex), 2);
        }
        return byteArray;
    }
}