/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.HistorialSolucionesDao;
import com.EquiposMedicos.domain.HistorialSoluciones;
import com.EquiposMedicos.service.HistorialSolucionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HistorialSolucionesServiceImpl implements HistorialSolucionesService {

    @Autowired
    private HistorialSolucionesDao historialSolucionesDao;

    @Override
    public List<HistorialSoluciones> getHistorialSoluciones(boolean activos) {
        var lista = historialSolucionesDao.findAll();
        // Aquí puedes agregar lógica adicional si es necesario
        return lista;
    }

    @Override
    public HistorialSoluciones getHistorialSolucionById(Long idHistorialSolucion) {
        return historialSolucionesDao.findById(idHistorialSolucion).orElse(null);
    }

    @Override
    public void saveHistorialSolucion(HistorialSoluciones historialSolucion) {
        historialSolucionesDao.save(historialSolucion);
    }

    @Override
    public void deleteHistorialSolucion(Long idHistorialSolucion) {
        historialSolucionesDao.deleteById(idHistorialSolucion);
    }
}
