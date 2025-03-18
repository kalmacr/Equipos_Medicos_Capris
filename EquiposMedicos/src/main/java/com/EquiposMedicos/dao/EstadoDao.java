/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.dao;

import com.EquiposMedicos.domain.Estado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Fabián Vargas
 */
public interface EstadoDao extends JpaRepository<Estado, Long> {

    List<Estado> findByTipoEstado(String tipoEstado);

    @Query("SELECT DISTINCT e.tipoEstado FROM Estado e")
    List<String> findDistinctTiposEstado();
}
