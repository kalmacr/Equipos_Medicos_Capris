/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.SolucionesDao;
import com.EquiposMedicos.domain.Soluciones;
import com.EquiposMedicos.domain.Soluciones;
import com.EquiposMedicos.service.SolucionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolucionesServiceImpl implements SolucionesService {

    @Autowired
    private SolucionesDao solucionesDao;

    @Override
    public List<Soluciones> getSoluciones(boolean activos) {
        var lista = solucionesDao.findAll();
        // Aquí puedes agregar lógica adicional si es necesario
        return lista;
    }

    @Override
    public Soluciones getSolucionById(Long idSolucion) {
        return solucionesDao.findById(idSolucion).orElse(null);
    }

    @Override
    public void saveSolucion(Soluciones solucion) {
        solucionesDao.save(solucion);
    }

    @Override
    public void deleteSolucion(Long idSolucion) {
        solucionesDao.deleteById(idSolucion);
    }
}

