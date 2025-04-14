/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.ComponentesDao;
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
public class ComponetesServiceImpl {
  @Service
public class ComponentesServiceImpl implements ComponentesService{
    
    @Autowired
    private ComponentesDao componetesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Componentes> listarComponentess() {
        return componetesDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Componentes encontrarComponentes(Componentes componetes) {
        return componetesDao.findById(componetes.getIdComponentes()).orElse(null);
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
    
}
  
}