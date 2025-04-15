/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.Estado;
import java.util.List;

/**
 *
 * @author Fabián Vargas
 */
public interface EstadoService {
    
   /* List<Estado> listarEstados();
    List<Estado> listarEstadosPorTipo(String tipoEstado);
    void guardar(Estado estado);
    void eliminar(Estado estado);
    */
   
    List<Estado> getEstados();
   
    List<Estado> listarEstadosPorTipo(String tipoEstado);
    
    void guardar(Estado estado);
  
    void eliminar(Estado estado);
    
    Estado encontrarEstados(Estado estados);
    
}
