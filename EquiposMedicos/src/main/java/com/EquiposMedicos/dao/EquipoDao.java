/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Equipo;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author kcalm
 */
public interface EquipoDao extends JpaRepository<Equipo, Long> {
    
    
    @Procedure(name = "insertar_equipos", procedureName = "equipos_mgmt.insertar_equipos")
    void insertarEquipo(
        @Param("p_nombre") String nombre,
        @Param("p_tipo") String tipo,
        @Param("p_fabricante") String fabricante,
        @Param("p_numeroserie") String numeroSerie,
        @Param("p_fechaadquisicion") LocalDate fechaAdquisicion,
        @Param("p_idUbicacion")  Long idUbicacion,
        @Param("p_idCategoria") Long idCategoria,
        @Param("p_idEstado") Long idEstado

    );
    
    @Procedure(name = "eliminar_equipos", procedureName = "equipos_mgmt.eliminar_equipos")
    void eliminarEquipo(@Param("p_idEquipos") Long idEquipo);
    
    @Procedure(name = "update_equipos", procedureName = "equipos_mgmt.update_equipos")
    void actualizarEquipo(
         @Param("p_idEquipos") Long idEquipo,
        @Param("p_nombre") String nombre,
        @Param("p_tipo") String tipo,
        @Param("p_fabricante") String fabricante,
        @Param("p_numeroserie") String numeroSerie,
        @Param("p_fechaadquisicion") LocalDate fechaAdquisicion,
        @Param("p_idUbicacion") Long idUbicacion,
        @Param("p_idCategoria") Long idCategoria,
        @Param("p_idEstado") Long idEstado
    );
}
