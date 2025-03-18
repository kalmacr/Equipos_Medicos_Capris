/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.UsuariosDao;
import com.EquiposMedicos.domain.Usuario;
import com.EquiposMedicos.service.UsuariosServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fabián Vargas
 */
@Service
public class UsuariosServiceImpl  implements UsuariosServices{
    
    @Autowired
    private UsuariosDao usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(boolean activos){
        var lista = usuarioDao.findAll();
        if (activos){
            lista.removeIf(e ->!e.isActivos());
        }
        
        return  lista;
    }
    
     @Override
    
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
