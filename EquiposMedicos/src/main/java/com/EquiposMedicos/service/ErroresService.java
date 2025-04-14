/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.Errores;
import java.util.List;

public interface ErroresService {
    List<Errores> getErrores(boolean activos);
 
    void saveError(Errores error);
    void deleteError(Long idError);
}
