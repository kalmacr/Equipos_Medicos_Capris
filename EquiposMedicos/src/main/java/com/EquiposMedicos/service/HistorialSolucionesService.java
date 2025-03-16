/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.HistorialSoluciones;
import java.util.List;



public interface HistorialSolucionesService {
    List<HistorialSoluciones> getHistorialSoluciones(boolean activos);
    HistorialSoluciones getHistorialSolucionById(Long idHistorialSolucion);
    void saveHistorialSolucion(HistorialSoluciones historialSolucion);
    void deleteHistorialSolucion(Long idHistorialSolucion);
}
