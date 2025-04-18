/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.CentroDao;
import com.EquiposMedicos.dao.CentrosRepositoryImpl;
import com.EquiposMedicos.domain.Centro;
import com.EquiposMedicos.service.CentroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author Fabián Vargas
 */
@Service
public class CentroServiceImpl implements CentroService{
    
    @Autowired
    private CentroDao centroDao;
    @Autowired
    private CentrosRepositoryImpl centrosRepositoryImpl;
    
/*    @Override
    @Transactional(readOnly = true)
    public List<Centro> listarCentros() {
        return centroDao.findAll();
    }
    
   @Override
   @Transactional(readOnly = true)
  public Centro encontrarCentro(Centro centro) {
  return centroDao.findById(centro.getIdCentro()).orElse(null);
}
    
    @Override
    @Transactional
    public void guardar(Centro centro) {
        centroDao.save(centro);
    }
    
    @Override
    @Transactional
    public void eliminar(Centro centro) {
        centroDao.delete(centro);
    }
    
    */
     @Override
    @Transactional(readOnly = true)
    public List<Centro> listarCentros() {
        return centrosRepositoryImpl.getCentro();
    }
    
   @Override
   @Transactional(readOnly = true)
  public Centro encontrarCentro(Centro centro) {
  return centroDao.findById(centro.getIdCentro()).orElse(null);
}
    
    @Override
    @Transactional
    public void guardar(Centro centro) {
        if (centro.getIdCentro()== null) {
            centroDao.insertarCentro(centro.getNombre(),centro.getTiempoRespuestaHoras());
        } else {
            centroDao.actualizarCentro(centro.getIdCentro(), centro.getNombre(), centro.getTiempoRespuestaHoras());
        }
    }
    
    @Override
    @Transactional
    public void eliminar(Centro centro) {
        centroDao.eliminarCentro(centro.getIdCentro());
    }
    
}
