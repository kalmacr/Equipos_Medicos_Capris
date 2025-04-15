/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.CategoriaEquipo;
import java.util.List;

/**
 *
 * @author Fabián Vargas
 */
public interface CategoriaEquipoService {
    List<CategoriaEquipo> listarCategorias();
    CategoriaEquipo encontrarCategoria(CategoriaEquipo categoria);
    void guardar(CategoriaEquipo categoria);
    void eliminar(CategoriaEquipo categoria);
}
