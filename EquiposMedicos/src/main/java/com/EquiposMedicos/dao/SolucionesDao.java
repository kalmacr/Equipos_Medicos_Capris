/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Soluciones;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;



public interface SolucionesDao extends JpaRepository<Soluciones, Long> {
    
    @Procedure(name = "insertar_solucion", procedureName = "soluciones_mgmt.insertar_solucion")
    void insertarEquipo(
        @Param("p_descripcion") String descripcion,
        @Param("p_fechaImplementacion") Date fechaImplementacion,
        @Param("p_idError") Long idError

    );
    
    @Procedure(name = "eliminar_solucion", procedureName = "soluciones_mgmt.eliminar_solucion")
    void eliminarEquipo(@Param("p_idSolucion") Long idSolucion);
    
    @Procedure(name = "actualizar_solucion", procedureName = "soluciones_mgmt.actualizar_solucion")
    void actualizarEquipo(
         @Param("p_idSolucion") Long idSolucion,
        @Param("p_descripcion") String descripcion,
        @Param("p_fechaImplementacion") Date fechaImplementacion,
        @Param("p_idError") Long idError
    );
}
