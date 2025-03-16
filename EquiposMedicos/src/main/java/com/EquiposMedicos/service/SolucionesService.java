/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.Soluciones;
import java.util.List;

public interface SolucionesService {
    List<Soluciones> getSoluciones(boolean activos);
    Soluciones getSolucionById(Long idSolucion);
    void saveSolucion(Soluciones solucion);
    void deleteSolucion(Long idSolucion);
}