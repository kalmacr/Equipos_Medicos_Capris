/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.HistorialUsuario;
import java.sql.Date;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author kcalm
 */
public interface HistorialUsuarioDao extends JpaRepository<HistorialUsuario, Long> {
    
    
    @Procedure(name = "insertar_historial_usuarios", procedureName = "historial_usuarios_mgmt.insertar_historial_usuarios")
    void insertarHistorial(
        @Param("p_idUsuario") Long idEquipo,
        @Param("p_fechaHora") LocalDateTime fechaHora,
        @Param("p_accion") String accion
    );
    
    @Procedure(name = "eliminar_historial_usuarios", procedureName = "historial_usuarios_mgmt.eliminar_historial_usuarios")
    void eliminarHistorial(@Param("p_idHistorial") Long idHistorial);
    
    @Procedure(name = "update_historial_usuarios", procedureName = "historial_usuarios_mgmt.update_historial_usuarios")
    void actualizarHistorial(
        @Param("p_idHistorial") Long idHistorial,
        @Param("p_idUsuario") Long idEquipo,
        @Param("p_fechaHora") LocalDateTime fechaHora,
        @Param("p_accion") String accion
    );
}
