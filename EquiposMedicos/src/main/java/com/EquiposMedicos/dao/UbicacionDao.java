/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Ubicacion;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Chope2805
 */
public interface UbicacionDao extends JpaRepository<Ubicacion, Long> {
    
    @Procedure(name = "insertar_ubicaciones", procedureName = "ubicaciones_mgmt.insertar_ubicaciones")
    void insertarEquipo(
        @Param("p_nombreUbicacion") String nombre,
        @Param("p_descripcion") String descripcion,
        @Param("p_responsable") String responsable,
        @Param("p_idCentro") Long idCentro

    );
    
    @Procedure(name = "eliminar_ubicaciones", procedureName = "ubicaciones_mgmt.eliminar_ubicaciones")
    void eliminarEquipo(@Param("p_idUbicacion") Long idUbicacion);
    
    @Procedure(name = "update_ubicaciones", procedureName = "ubicaciones_mgmt.update_ubicaciones")
    void actualizarEquipo(
        @Param("p_idUbicacion") Long idUbicacion,
        @Param("p_nombreUbicacion") String nombre,
        @Param("p_descripcion") String descripcion,
        @Param("p_responsable") String responsable,
        @Param("p_idCentro") Long idCentro
    );
    
}