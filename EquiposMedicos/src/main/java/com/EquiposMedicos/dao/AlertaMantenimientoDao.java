/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.AlertaMantenimiento;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author kcalm
 */
public interface AlertaMantenimientoDao extends JpaRepository<AlertaMantenimiento, Long>{
//    List<AlertaMantenimiento> findAlertaMantenimientos(String alertaMantenimiento);
//    
    
    @Procedure(name = "insertar_alertas_mantenimiento", procedureName = "alertas_mantenimiento_mgmt.insertar_alertas_mantenimiento")
    void insertarAlertas(
        @Param("p_idEquipo") Long idEquipo,
        @Param("p_fechaAlerta") Date fechaAlerta,
        @Param("p_motivo") String motivo,
        @Param("p_idEstado") Long idEstado
 

    );
    
    @Procedure(name = "eliminar_alertas_mantenimiento", procedureName = "alertas_mantenimiento_mgmt.eliminar_alertas_mantenimiento")
    void eliminarAlertas(@Param("p_idAlerta") Long idAlerta);
    
    @Procedure(name = "update_alertas_mantenimiento", procedureName = "alertas_mantenimiento_mgmt.update_alertas_mantenimiento")
    void actualizarAlertas(
        @Param("p_idAlerta") Long idAlerta,
        @Param("p_idEquipo") Long idEquipo,
        @Param("p_fechaAlerta") Date fechaAlerta,
        @Param("p_motivo") String motivo,
        @Param("p_idEstado") Long idEstado
    );
}
