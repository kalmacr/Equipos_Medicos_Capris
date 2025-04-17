/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Errores;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

    
    public interface ErroresDao extends JpaRepository<Errores, Long> {
        
         @Procedure(name = "insertar_error", procedureName = "errores_mgmt.insertar_error")
    void insertarEquipo(
        @Param("p_codigoError") String codigoError,
        @Param("p_descripcion") String descripcion,
        @Param("p_fechaRegistro") Date fechaRegistro,
        @Param("p_tipo") String tipo

    );
    
    @Procedure(name = "eliminar_error", procedureName = "errores_mgmt.eliminar_error")
    void eliminarEquipo(@Param("p_idError") Long idError);
    
    @Procedure(name = "update_equipos", procedureName = "errores_mgmt.actualizar_error")
    void actualizarEquipo(
         @Param("p_idError") Long idError,
        @Param("p_codigoError") String codigoError,
        @Param("p_descripcion") String descripcion,
        @Param("p_fechaRegistro") Date fechaRegistro,
        @Param("p_tipo") String tipo
    );
}
    

