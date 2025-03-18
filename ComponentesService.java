/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;
import com.EquiposMedicos.domain.Componentes;
import java.util.List;

/**
 *
 * @author Chope2805
 */

public interface ComponentesService {
    
    List<Componentes> listarComponentess();
    Componentes encontrarComponentes(Componentes componetes);
    void guardar(Componentes componetes);
    void eliminar(Componentes componetes);
}

