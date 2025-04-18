/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.ErroresPorCategoriaDao;
import com.EquiposMedicos.dao.ErroresPorCategoriaRepositoryImpl;
import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Errores;
import com.EquiposMedicos.domain.ErroresPorCategoria;
import com.EquiposMedicos.service.ErroresPorCategoriaService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kcalm
 */
@Service
public class ErroresPorCategoriaServiceImpl implements ErroresPorCategoriaService{
    
    @Autowired
    private ErroresPorCategoriaDao erroresPorCategoriaDao;
    @Autowired
    private ErroresPorCategoriaRepositoryImpl erroresPorCategoriaRepositoryImpl;
    
    
    /*
    @Override
    @Transactional(readOnly = true)
    public List<ErroresPorCategoria> listarErroresPorCategoria() {
        return erroresPorCategoriaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ErroresPorCategoria erroresPorCategoria(ErroresPorCategoria erroresPorCategoria) {
        return erroresPorCategoriaDao.findById(erroresPorCategoria.getIdErrorCategoria()).orElse(null);
    }
    

    @Override
    @Transactional
    public void guardar(ErroresPorCategoria erroresPorCategoria) {
        erroresPorCategoriaDao.save(erroresPorCategoria);
    }

    @Override
    @Transactional
    public void eliminar(ErroresPorCategoria erroresPorCategoria) {
        erroresPorCategoriaDao.delete(erroresPorCategoria);
    }

  */
 @Override
    @Transactional(readOnly = true)
    public List<ErroresPorCategoria> listarErroresPorCategoria() {
        return erroresPorCategoriaRepositoryImpl.getErroresCateg();
    }

    @Override
    @Transactional(readOnly = true)
    public ErroresPorCategoria erroresPorCategoria(ErroresPorCategoria erroresPorCategoria) {
        return erroresPorCategoriaDao.findById(erroresPorCategoria.getIdErrorCategoria()).orElse(null);
    }
    

    @Override
    @Transactional
    public void guardar(ErroresPorCategoria erroresPorCategoria) {
        if(erroresPorCategoria.getIdErrorCategoria() == null){
            erroresPorCategoriaDao.insertarErrroresCate(erroresPorCategoria.getCategoriaEquipo().getIdCategoria(), 
                    erroresPorCategoria.getErrores().getIdError(), erroresPorCategoria.getFechaRegistro());
        }else{
            erroresPorCategoriaDao.actualizarErrroesPorca(erroresPorCategoria.getIdErrorCategoria(),
                    erroresPorCategoria.getCategoriaEquipo().getIdCategoria(), 
                    erroresPorCategoria.getErrores().getIdError(), erroresPorCategoria.getFechaRegistro());
        }
    }

    @Override
    @Transactional
    public void eliminar(ErroresPorCategoria erroresPorCategoria) {
        erroresPorCategoriaDao.delete(erroresPorCategoria);
    }
    

    
}
