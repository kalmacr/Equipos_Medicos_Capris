/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

/**
 *
 * @author Fabián Vargas
 */
import com.EquiposMedicos.dao.CategoriaEquipoDao;
import com.EquiposMedicos.dao.CategoriaEquipoRepositoryImpl;
import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.service.CategoriaEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CategoriaEquipoServiceImpl implements CategoriaEquipoService {

    @Autowired
    private CategoriaEquipoDao categoriaDao;
    @Autowired
    private CategoriaEquipoRepositoryImpl categoriaEquipoRepositoryImpl;

    /*  @Override
    @Transactional(readOnly = true)
    public List<CategoriaEquipo> listarCategorias() {
        return categoriaDao.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public CategoriaEquipo encontrarCategoria(CategoriaEquipo categoria) {
     return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
 }
    
    @Override
    @Transactional
    public void guardar(CategoriaEquipo categoria) {
        categoriaDao.save(categoria);
    }
    
    @Override
    @Transactional
    public void eliminar(CategoriaEquipo categoria) {
        categoriaDao.delete(categoria);
    }
    
     */
    @Override
    @Transactional(readOnly = true)
    public List<CategoriaEquipo> listarCategorias() {
        return categoriaEquipoRepositoryImpl.getCategoriaEquipos();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaEquipo encontrarCategoria(CategoriaEquipo categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(CategoriaEquipo categoria) {
        if (categoria.getIdCategoria() == null) {
            categoriaDao.insertarCategoriaEquipoDao(categoria.getNombreCategoria()
            );
        } else {
            categoriaDao.actualizarCategoriaEquipoDao(categoria.getIdCategoria(),categoria.getNombreCategoria());
        }
    }

    @Override
    @Transactional
    public void eliminar(CategoriaEquipo categoria) {
        categoriaDao.eliminarCategoriaEquipoDao(categoria.getIdCategoria());
    }
}
