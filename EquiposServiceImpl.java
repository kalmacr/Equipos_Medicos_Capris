/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;
import com.EquiposMedicos.dao.EquiposDao;
import com.EquiposMedicos.domain.Equipos;
import com.EquiposMedicos.service.EquiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EquiposServiceImpl implements EquiposService{
    
    @Autowired
    private EquiposDao equiposDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Equipos> listarEquiposs() {
        return equiposDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Equipos encontrarEquipos(Equipos equipos) {
        return equiposDao.findById(equipos.getIdEquipos()).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardar(Equipos equipos) {
        equiposDao.save(equipos);
    }
    
    @Override
    @Transactional
    public void eliminar(Equipos equipos) {
        equiposDao.delete(equipos);
    }
    
}
