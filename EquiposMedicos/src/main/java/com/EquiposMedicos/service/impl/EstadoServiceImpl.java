/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

/**
 *
 * @author Fabián Vargas
 */
import com.EquiposMedicos.dao.EstadoDao;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService{
     @Autowired
    private EstadoDao estadoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Estado> listarEstados() {
        return estadoDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Estado> listarEstadosPorTipo(String tipoEstado) {
        return estadoDao.findByTipoEstado(tipoEstado);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Estado encontrarEstado(Estado estado) {
        return estadoDao.findById(estado.getIdEstado()).orElse(null);
    }
    
    @Override
    @Transactional
    public void guardar(Estado estado) {
        estadoDao.save(estado);
    }
    
    @Override
    @Transactional
    public void eliminar(Estado estado) {
        estadoDao.delete(estado);
    }
}
