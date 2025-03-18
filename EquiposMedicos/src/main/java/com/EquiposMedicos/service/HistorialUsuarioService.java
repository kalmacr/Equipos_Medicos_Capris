/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;
import com.EquiposMedicos.domain.HistorialUsuario;
import java.util.List;

/**
 *
 * @author kcalm
 */
public interface HistorialUsuarioService {
    List<HistorialUsuario> listarHistorialUsuario();
    HistorialUsuario encontrarHistorialUsuario(HistorialUsuario historialUsuario);
    void guardar(HistorialUsuario historialUsuario);
    void eliminar(HistorialUsuario historialUsuario);
    
    
}
