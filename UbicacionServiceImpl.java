/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;
import com.EquiposMedicos.dao.UbicacionDao;
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
    
    @Override
    @Transactional(readOnly = true)
    public List<Ubicacion> listarUbicacions() {
        return ubicacionDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Ubicacion> listarUbicacionsPorTipo(String tipoUbicacion) {
        return ubicacionDao.findByTipoUbicacion(tipoUbicacion);
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
}
