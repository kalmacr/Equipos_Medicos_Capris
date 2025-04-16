/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.PrioridadError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Fabián Vargas
 */
public interface PrioridadErrorDao extends JpaRepository<PrioridadError, Long>{
     
    @Procedure(name = "insertar_prioridad_error", procedureName = "prioridad_error_mgmt.insertar_prioridad_error")
    void insertarPrioridadError(
        @Param("p_descripcion") String descripcion,
        @Param("p_tiempoRespuestaEstimada") int tiempoRespuestaEstimada
    );
    
    @Procedure(name = "eliminar_prioridad_error", procedureName = "prioridad_error_mgmt.eliminar_prioridad_error")
    void eliminarPrioridadError(@Param("p_idPrioridad") Long idPrioridad);
    
    @Procedure(name = "actualizar_prioridad_error", procedureName = "prioridad_error_mgmt.actualizar_prioridad_error")
    void actualizarPrioridadError(
        @Param("p_idPrioridadError") Long idPrioridad,
        @Param("p_descripcion") String descripcion,
        @Param("p_tiempoRespuestaEstimada") int tiempoRespuestaEstimada
    );
    
}
