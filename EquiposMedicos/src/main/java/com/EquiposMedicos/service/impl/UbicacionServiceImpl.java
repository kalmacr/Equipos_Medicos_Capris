/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.UbicacionDao;
import com.EquiposMedicos.dao.UbicacionesRepositoryImpl;
import com.EquiposMedicos.domain.Ubicacion;
import com.EquiposMedicos.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 *
 * @author Chope2805
 */
@Service
public class UbicacionServiceImpl implements UbicacionService{
     @Autowired
    private UbicacionDao ubicacionDao;
     
     @Autowired
    private UbicacionesRepositoryImpl ubicacionesRepositoryImpl;
    /*
    @Override
    @Transactional(readOnly = true)
    public List<Ubicacion> listarUbicacions() {
        return ubicacionDao.findAll();
    }
    
  
    @Override
    @Transactional(readOnly = true)
    public Ubicacion encontrarUbicacion(Ubicacion ubicacion) {
        return ubicacionDao.findById(ubicacion.getIdUbicacion()).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardar(Ubicacion ubicacion) {
        ubicacionDao.save(ubicacion);
    }
    
    @Override
    @Transactional
    public void eliminar(Ubicacion ubicacion) {
        ubicacionDao.delete(ubicacion);
    }
*/
     
     @Override
    @Transactional(readOnly = true)
    public List<Ubicacion> listarUbicacions() {
        return ubicacionesRepositoryImpl.getUbicaciones();
    }
    
  
    @Override
    @Transactional(readOnly = true)
    public Ubicacion encontrarUbicacion(Ubicacion ubicacion) {
        return ubicacionDao.findById(ubicacion.getIdUbicacion()).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardar(Ubicacion ubicacion) {
        if(ubicacion.getIdUbicacion() == null){
            ubicacionDao.insertarEquipo(ubicacion.getNombre(), ubicacion.getDescripcion(), 
                    ubicacion.getResponsable(), ubicacion.getCentro().getIdCentro());
        }
        else{
            ubicacionDao.actualizarEquipo(ubicacion.getIdUbicacion(),ubicacion.getNombre(), ubicacion.getDescripcion(), 
                    ubicacion.getResponsable(), ubicacion.getCentro().getIdCentro());
        }
    }
    
    @Override
    @Transactional
    public void eliminar(Ubicacion ubicacion) {
        ubicacionDao.eliminarEquipo(ubicacion.getIdUbicacion());
    }
}