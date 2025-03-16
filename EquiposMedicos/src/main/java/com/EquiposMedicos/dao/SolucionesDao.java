/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Soluciones;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SolucionesDao extends JpaRepository<Soluciones, Long> {
}
