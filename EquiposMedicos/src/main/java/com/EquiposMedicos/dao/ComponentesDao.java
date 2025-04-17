/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;


import com.EquiposMedicos.domain.Componentes;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Chope2805
 */
public interface ComponentesDao extends JpaRepository<Componentes, Long> {
    
     @Procedure(name = "insertar_componentes", procedureName = "componentes_mgmt.insertar_componentes")
    void insertarComponentes(
        @Param("p_nombre") String nombre,
        @Param("p_estado") String estado,
        @Param("p_fechainstalacion") Date fechaInstalacion,
        @Param("p_idEquipo") Long idEquipo
 

    );
    
    @Procedure(name = "eliminar_componentes", procedureName = "componentes_mgmt.eliminar_componentes")
    void eliminarComponentes(@Param("p_idComponentes") Long idComponente);
    
    @Procedure(name = "update_componentes", procedureName = "componentes_mgmt.update_componentes")
    void actualizarComponentes(
         @Param("p_idComponentes") Long idComponente,
        @Param("p_nombre") String nombre,
        @Param("p_estado") String estado,
        @Param("p_fechainstalacion") Date fechaInstalacion,
        @Param("p_idEquipo") Long idEquipo
    );
}
