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
import com.EquiposMedicos.dao.EstadoRepositoryImpl;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.service.EstadoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    private EstadoDao estadoDao;
    @Autowired
    private EstadoRepositoryImpl estadoDao2;
    /*
    
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
    
//    @Override
//    @Transactional(readOnly = true)
//    public Estado encontrarEstado(Estado estado) {
//        return estadoDao.findById(estado.getIdEstado()).orElse(null);
//    }
    
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

     */
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Estado> getEstados() {
            
            return estadoDao2.getEstados();
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Estado> listarEstadosPorTipo(String tipoEstado) {
        return estadoDao.findByTipoEstado(tipoEstado);
    }

    @Override
    @Transactional
    public void guardar(Estado estado) {
        if (estado.getIdEstado() == null) {
            estadoDao.insertarEstado(
                    estado.getNombreEstado(),
                    estado.getDescripcion(),
                    estado.getTipoEstado()
            );
        } else {
            estadoDao.actualizarEstado(
                    estado.getIdEstado(),
                    estado.getNombreEstado(),
                    estado.getDescripcion(),
                    estado.getTipoEstado()
            );
        }
    }

    @Override
    @Transactional
    public void eliminar(Estado estado) {
        estadoDao.eliminarEstado(estado.getIdEstado());
    }

    @Override
    @Transactional
    public Estado encontrarEstados(Estado estados) {
        return estadoDao.findById(estados.getIdEstado()).orElse(null);
    }

}
