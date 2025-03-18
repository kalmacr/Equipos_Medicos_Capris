/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;
import com.EquiposMedicos.domain.Ubicacion;
import java.util.List;
/**
 *
 * @author Chope2805
 */
public interface UbicacionService {
    
    List<Ubicacion> listarUbicacions();
    List<Ubicacion> listarUbicacionsPorTipo(String tipoUbicacion);
    Ubicacion encontrarUbicacion(Ubicacion estado);
    void guardar(Ubicacion estado);
    void eliminar(Ubicacion estado);
}

