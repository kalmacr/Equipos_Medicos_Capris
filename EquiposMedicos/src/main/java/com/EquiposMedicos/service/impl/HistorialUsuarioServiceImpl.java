/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;


import com.EquiposMedicos.dao.HistorialUsuarioDao;
import com.EquiposMedicos.dao.HistorialUsuarioRepositoryImpl;
import com.EquiposMedicos.domain.HistorialUsuario;
import com.EquiposMedicos.service.HistorialUsuarioService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kcalm
 */
@Service
public class HistorialUsuarioServiceImpl implements HistorialUsuarioService{
    
     @Autowired
    private HistorialUsuarioDao historialUsuarioDao;
     
     @Autowired
     private HistorialUsuarioRepositoryImpl historialUsuarioRepositoryImpl;
    
     /*
    @Override
    @Transactional(readOnly = true)
    public List<HistorialUsuario> listarHistorialUsuario() {
        return historialUsuarioDao.findAll();  
    }

    @Override
    public HistorialUsuario encontrarHistorialUsuario(HistorialUsuario historialUsuario) {
        return historialUsuarioDao.findById(historialUsuario.getIdHistorial()).orElse(null);
    }

    @Override
    public void guardar(HistorialUsuario historialUsuario) {
        historialUsuarioDao.save(historialUsuario);
    }

    @Override
    public void eliminar(HistorialUsuario historialUsuario) {
        historialUsuarioDao.delete(historialUsuario);
    }
    */
     
     @Override
    @Transactional(readOnly = true)
    public List<HistorialUsuario> listarHistorialUsuario() {
        return historialUsuarioRepositoryImpl.getHistorial();  
    }

    @Override
    public HistorialUsuario encontrarHistorialUsuario(HistorialUsuario historialUsuario) {
        return historialUsuarioDao.findById(historialUsuario.getIdHistorial()).orElse(null);
    }

    @Override
    public void guardar(HistorialUsuario historialUsuario) {
        if(historialUsuario.getIdHistorial() == null){
            historialUsuarioDao.insertarHistorial(historialUsuario.getUsuario().getIdUsuario(), historialUsuario.getFechaHora(), historialUsuario.getAccion());
        }else{
            historialUsuarioDao.actualizarHistorial(historialUsuario.getIdHistorial(),
                    historialUsuario.getUsuario().getIdUsuario(), historialUsuario.getFechaHora(), historialUsuario.getAccion());
        }
    }

    @Override
    public void eliminar(HistorialUsuario historialUsuario) {
        historialUsuarioDao.eliminarHistorial(historialUsuario.getIdHistorial());
    }
}
