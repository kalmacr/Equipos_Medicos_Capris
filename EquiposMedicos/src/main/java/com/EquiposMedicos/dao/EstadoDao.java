/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Estado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Fabián Vargas
 */
public interface EstadoDao extends JpaRepository<Estado, Long> {

    List<Estado> findByTipoEstado(String tipoEstado);

    @Query("SELECT DISTINCT e.tipoEstado FROM Estado e")
    List<String> findDistinctTiposEstado();
    
    @Procedure(procedureName = "insertar_estado")
    void insertarEstado(
        @Param("p_nombreEstado") String nombreEstado,
        @Param("p_descripcion") String descripcion,
        @Param("p_tipoEstado") String tipoEstado
    );
    
    @Procedure(procedureName = "eliminar_estado")
    void eliminarEstado(@Param("p_idEstado") Long idEstado);
}
