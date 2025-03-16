/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.Centro;
import java.util.List;

/**
 *
 * @author Fabián Vargas
 */
public interface CentroService {
    
    List<Centro> listarCentros();
    //Centro encontrarCentro(Centro centro);
    void guardar(Centro centro);
    void eliminar(Centro centro);
}
