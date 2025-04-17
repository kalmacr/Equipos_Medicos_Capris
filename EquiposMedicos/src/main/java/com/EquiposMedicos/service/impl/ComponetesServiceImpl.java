/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.ComponentesDao;
import com.EquiposMedicos.dao.ComponetnesRepositoryImpl;
import com.EquiposMedicos.domain.Componentes;
import com.EquiposMedicos.service.ComponentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/**
 *
 * @author Chope2805
 */

  @Service
public class ComponetesServiceImpl implements ComponentesService{
    
    @Autowired
    private ComponentesDao componetesDao;
    
    @Autowired
    private ComponetnesRepositoryImpl componetnesRepositoryImpl;
    /*
    @Override
    @Transactional(readOnly = true)
    public List<Componentes> listarComponentess() {
        return componetesDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Componentes encontrarComponentes(Componentes componetes) {
        return componetesDao.findById(componetes.getIdComponente()).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardar(Componentes componetes) {
        componetesDao.save(componetes);
    }
    
    @Override
    @Transactional
    public void eliminar(Componentes componetes) {
        componetesDao.delete(componetes);
    }
    */
    
    @Override
    @Transactional(readOnly = true)
    public List<Componentes> listarComponentess() {
        return componetnesRepositoryImpl.getComponentes();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Componentes encontrarComponentes(Componentes componetes) {
        return componetesDao.findById(componetes.getIdComponente()).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardar(Componentes componetes) {
        if(componetes.getIdComponente() == null){
            componetesDao.insertarComponentes(componetes.getNombre(), componetes.getEstado(), 
                    componetes.getFechaInstalacion(), componetes.getEquipo().getIdEquipo());
        }else{
            componetesDao.actualizarComponentes(componetes.getIdComponente(),componetes.getNombre(), componetes.getEstado(), 
                    componetes.getFechaInstalacion(), componetes.getEquipo().getIdEquipo());
        }
            
    }
    
    @Override
    @Transactional
    public void eliminar(Componentes componetes) {
        componetesDao.eliminarComponentes(componetes.getIdComponente());
    }
}
  
