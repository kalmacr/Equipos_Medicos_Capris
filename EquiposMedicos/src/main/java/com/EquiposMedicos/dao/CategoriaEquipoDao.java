/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.CategoriaEquipo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Fabián Vargas
 */
public interface CategoriaEquipoDao extends JpaRepository<CategoriaEquipo, Long>{
    
}



