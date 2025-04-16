/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Fabián Vargas
 */
public interface CentroDao extends JpaRepository<Centro, Long>{
    
    @Procedure(name = "insertar_centro", procedureName = "centros_mgmt.insertar_centro")
    void insertarCentro(
        @Param("p_nombre") String nombre,
        @Param("p_tiempoRespuestaHoras") int tiempoRespuestaHoras
    );
    
    @Procedure(name = "eliminar_centro", procedureName = "centros_mgmt.eliminar_centro")
    void eliminarCentro(@Param("p_idCentro") Long idCentro);
    
    @Procedure(name = "actualizar_centro", procedureName = "centros_mgmt.actualizar_centro")
    void actualizarCentro(
        @Param("p_idUsuario") Long idCentro,
        @Param("p_nombre") String nombre,
        @Param("p_correo") int tiempoRespuestaHoras
    );
}
