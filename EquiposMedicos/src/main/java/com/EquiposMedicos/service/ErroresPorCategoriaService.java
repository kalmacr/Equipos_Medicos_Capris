/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.ErroresPorCategoria;
import java.util.List;

/**
 *
 * @author kcalm
 */
public interface ErroresPorCategoriaService {
    List<ErroresPorCategoria> listarErroresPorCategoria();
    ErroresPorCategoria erroresPorCategoria(ErroresPorCategoria erroresPorCategoria);
    void guardar(ErroresPorCategoria erroresPorCategoria);
    void eliminar(ErroresPorCategoria erroresPorCategoria);
}
