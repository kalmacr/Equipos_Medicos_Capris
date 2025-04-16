/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.UsuarioRepositoryImpl;
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
    
    @Autowired
    private UsuarioRepositoryImpl usuarioRepositoryImpl;
    /*
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(boolean activos){
        var lista = usuarioDao.findAll();
        if (activos){
         //   lista.removeIf(e ->!e.isActivos());
        }
        
        return  lista;
    }
    
//<<<<<<< kevin
 //    @Override
    
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }
//     @Override
//    @Transactional(readOnly = true)
//    public Usuario getUsuario(Usuario usuario) {
//        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
//    }
//>>>>>>> main

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
*/
    
      @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarios(boolean activos){        
        return  usuarioRepositoryImpl.getUsuario(1L);
    }
    
    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        if (usuario.getIdUsuario()== null) {
            usuarioDao.insertarEstado(usuario.getNombre(), usuario.getCorreo(), usuario.getRol(), 
                    usuario.getContrasena());
        } else {
            usuarioDao.actualizarEstado(usuario.getIdUsuario(),usuario.getNombre(), usuario.getCorreo(), usuario.getRol(), 
                    usuario.getContrasena());
        }
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.eliminarEstado(usuario.getIdUsuario());
    }
}
