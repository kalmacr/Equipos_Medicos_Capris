/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.PrioridadError;
import java.util.List;

/**
 *
 * @author Fabián Vargas
 */
public interface PrioridadErrorService {
    
    List<PrioridadError> listarPrioridades();
    //PrioridadError encontrarPrioridad(PrioridadError prioridad);
    void guardar(PrioridadError prioridad);
    void eliminar(PrioridadError prioridad);
}
