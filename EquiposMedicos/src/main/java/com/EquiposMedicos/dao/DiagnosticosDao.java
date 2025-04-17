/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Diagnosticos;
import java.sql.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface DiagnosticosDao extends JpaRepository<Diagnosticos, Long> {
    
    @Procedure(name = "insertar_diagnostico", procedureName = "diagnosticos_mgmt.insertar_diagnostico")
    void insertarEquipo(
        @Param("p_idEquipo") Long idEquipo,
        @Param("p_fecha") Date fecha,
        @Param("p_descripcionProblema") String descripcionProblema,
        @Param("p_idError") Long idError,
        @Param("p_idSolucion") Long idSolucion

    );
    
    @Procedure(name = "eliminar_diagnostico", procedureName = "diagnosticos_mgmt.eliminar_diagnostico")
    void eliminarEquipo(@Param("p_idDiagnostico") Long idDiagnostico);
    
    @Procedure(name = "actualizar_diagnostico", procedureName = "diagnosticos_mgmt.actualizar_diagnostico")
    void actualizarEquipo(
         @Param("p_idDiagnostico") Long idDiagnostico,
        @Param("p_idEquipo") Long idEquipo,
        @Param("p_fecha") Date fecha,
        @Param("p_descripcionProblema") String descripcionProblema,
        @Param("p_idError") Long idError,
        @Param("p_idSolucion") Long idSolucion
    );
    
}
