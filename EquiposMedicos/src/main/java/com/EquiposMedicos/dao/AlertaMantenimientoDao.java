/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.AlertaMantenimiento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kcalm
 */
public interface AlertaMantenimientoDao extends JpaRepository<AlertaMantenimiento, Long>{
//    List<AlertaMantenimiento> findAlertaMantenimientos(String alertaMantenimiento);
//    
}
