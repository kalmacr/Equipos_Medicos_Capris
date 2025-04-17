/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.ErroresDao;
import com.EquiposMedicos.dao.ErroresRepositoryImpl;
import com.EquiposMedicos.dao.UsuariosDao;
import com.EquiposMedicos.domain.Errores;
import com.EquiposMedicos.domain.Usuario;
import com.EquiposMedicos.service.ErroresService;
import com.EquiposMedicos.service.UsuariosServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErroresServiceImpl implements ErroresService {

    @Autowired
    private ErroresDao erroresDao;

    @Autowired
    private ErroresRepositoryImpl erroresRepositoryImpl;
   
    
    /*
     @Override
    public List<Errores> getErrores(boolean activos) {
        var lista = erroresDao.findAll();
        // Aquí puedes agregar lógica adicional si es necesario
        return lista;
    }

   

    @Override
    public void saveError(Errores error) {
        erroresDao.save(error);
    }

    @Override
    public void deleteError(Long idError) {
        erroresDao.deleteById(idError);
    }
    
    @Override
    public Errores getError(Errores error) {
      
      return erroresDao.findById(error.getIdError()).orElse(null);
    }
*/
    
    @Override
    public List<Errores> getErrores(boolean activos) {
        var lista = erroresRepositoryImpl.getErrores();
        return lista;
    }

   

    @Override
    public void saveError(Errores error) {
        if(error.getIdError() ==null){
            erroresDao.insertarEquipo(error.getCodigoError(), error.getDescripcion(), error.getFechaRegistro(), error.getTipo());
        }else
        {
            erroresDao.actualizarEquipo(error.getIdError(),error.getCodigoError(), error.getDescripcion(), error.getFechaRegistro(), error.getTipo());
        }
    }

    @Override
    public void deleteError(Long idError) {
        erroresDao.eliminarEquipo(idError);
    }
    
    @Override
    public Errores getError(Errores error) {
      
      return erroresDao.findById(error.getIdError()).orElse(null);
    }
    
    @Override
    public Errores getErrorByID(Long idError) {
      
      return erroresDao.findById(idError).orElse(null);
    }
    
}
