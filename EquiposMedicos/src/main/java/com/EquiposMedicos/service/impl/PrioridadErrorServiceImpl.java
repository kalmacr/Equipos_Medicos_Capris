/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

/**
 *
 * @author Fabián Vargas
 */
import com.EquiposMedicos.dao.PrioridadErrorDao;
import com.EquiposMedicos.dao.PrioridadErrorRepositoryImpl;
import com.EquiposMedicos.domain.PrioridadError;
import com.EquiposMedicos.service.PrioridadErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PrioridadErrorServiceImpl implements PrioridadErrorService {
    @Autowired
    private PrioridadErrorDao prioridadDao;
    @Autowired
    private PrioridadErrorRepositoryImpl prioridadErrorRepositoryImpl;
    /*
    @Override
    @Transactional(readOnly = true)
    public List<PrioridadError> listarPrioridades() {
        return prioridadDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public PrioridadError encontrarPrioridad(PrioridadError prioridad) {
        return prioridadDao.findById(prioridad.getIdPrioridad()).orElse(null);
}
    
    @Override
    @Transactional
    public void guardar(PrioridadError prioridad) {
        prioridadDao.save(prioridad);
    }
    
    @Override
    @Transactional
    public void eliminar(PrioridadError prioridad) {
        prioridadDao.delete(prioridad);
    }*/
    
    
    @Override
    @Transactional(readOnly = true)
    public List<PrioridadError> listarPrioridades() {
        return prioridadErrorRepositoryImpl.getPriporidad();
    }
    
    @Override
    @Transactional(readOnly = true)
    public PrioridadError encontrarPrioridad(PrioridadError prioridad) {
        return prioridadDao.findById(prioridad.getIdPrioridad()).orElse(null);
}
    
    @Override
    @Transactional
    public void guardar(PrioridadError prioridad) {
        if(prioridad.getIdPrioridad() == null ){
            prioridadDao.insertarPrioridadError(prioridad.getDescripcion(), prioridad.getTiempoRespuestaEstimada());
        }else{
            prioridadDao.actualizarPrioridadError(prioridad.getIdPrioridad(), prioridad.getDescripcion(), prioridad.getTiempoRespuestaEstimada());
        }
    }
    
    @Override
    @Transactional
    public void eliminar(PrioridadError prioridad) {
        prioridadDao.eliminarPrioridadError(prioridad.getIdPrioridad());
    }
}
