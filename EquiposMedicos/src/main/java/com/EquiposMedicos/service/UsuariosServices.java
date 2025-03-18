/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.Usuario;
import java.util.List;

/**
 *
 * @author Fabián Vargas
 */
public interface UsuariosServices {
    
    
    public List<Usuario> getUsuarios(boolean activos);
    
    
    //public Usuario getUsuario(Usuario usuario);
    

    public void save(Usuario usuario);
    
    
    public void delete(Usuario usuario);
}
