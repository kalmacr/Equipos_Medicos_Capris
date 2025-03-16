/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service;

import java.util.List;

public interface ErroresService {
    List<Error> getErrores(boolean activos);
    Error getErrorById(Long idError);
    void saveError(Error error);
    void deleteError(Long idError);
}
