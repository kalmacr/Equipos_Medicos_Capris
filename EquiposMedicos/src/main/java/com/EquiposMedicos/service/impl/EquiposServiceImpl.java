/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.EquipoDao;
import com.EquiposMedicos.domain.Equipo;
import com.EquiposMedicos.service.EquiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EquiposServiceImpl implements EquiposService{
    
    @Autowired
    private EquipoDao equiposDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Equipo> listarEquiposs() {
        return equiposDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Equipo encontrarEquipos(Equipo equipos) {
        return equiposDao.findById(equipos.getIdEquipo()).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardar(Equipo equipos) {
        equiposDao.save(equipos);
    }
    
    @Override
    @Transactional
    public void eliminar(Equipo equipos) {
        equiposDao.delete(equipos);
    }
    
}