/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unillanos.proyecto.File.integrity.repository;

import com.unillanos.proyecto.File.integrity.entity.FileIntegrityEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author andre
 */
public interface FileIntegrityRepository extends JpaRepository<FileIntegrityEntity, Long> {
    List<FileIntegrityEntity> findByHash(String hash);
}
