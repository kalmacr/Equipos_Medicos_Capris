/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.Equipo;
import java.util.List;
/**
 *
 * @author Chope2805
 */public interface EquiposService {
    
    List<Equipo> listarEquiposs();
    Equipo encontrarEquipos(Equipo centro);
    Equipo encontrarEquiposbyId(Long idEquipo);
    
    List<Equipo> listarPorCategoria(Long idCategoria);
    void guardar(Equipo centro);
    void eliminar(Equipo centro);
    
}