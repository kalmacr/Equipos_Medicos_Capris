/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.CategoriaEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Fabián Vargas
 */
public interface CategoriaEquipoDao extends JpaRepository<CategoriaEquipo, Long>{
    
     @Procedure(name = "insertar_categoria_equipo", procedureName = "categoria_equipo_mgmt.insertar_categoria_equipo")
    void insertarCategoriaEquipoDao(
        @Param("p_nombreCategoria") String nombreCategoria
    );
    
    @Procedure(name = "eliminar_categoria_equipo", procedureName = "categoria_equipo_mgmt.eliminar_categoria_equipo")
    void eliminarCategoriaEquipoDao(@Param("p_idCategoria") Long idCategoria);
    
    @Procedure(name = "actualizarEstado", procedureName = "categoria_equipo_mgmt.actualizar_categoria_equipo")
    void actualizarCategoriaEquipoDao(
        @Param("p_idCategoria") Long idCategoria,    
        @Param("p_nombreCategoria") String nombreCategoria
    );
}



