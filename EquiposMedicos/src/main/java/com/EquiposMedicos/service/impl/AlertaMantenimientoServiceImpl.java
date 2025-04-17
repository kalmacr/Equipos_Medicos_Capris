package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.AlertaMantenimientoDao;
import com.EquiposMedicos.dao.AlertasMantenimientoRepositoryImpl;
import com.EquiposMedicos.domain.AlertaMantenimiento;
import com.EquiposMedicos.service.AlertaMantenimientoService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kcalm
 */
@Service
public class AlertaMantenimientoServiceImpl implements AlertaMantenimientoService {

    @Autowired
    private AlertaMantenimientoDao alertaMantenimientoDao;

    @Autowired
    private AlertasMantenimientoRepositoryImpl alertasMantenimientoRepositoryImpl;

    /*
    @Override
    @Transactional(readOnly = true)
    public List<AlertaMantenimiento> listarAlertaMantenimientos() {
        return alertaMantenimientoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public AlertaMantenimiento encontrarAlertaMantenimiento(AlertaMantenimiento alertaMantenimiento) {
        return alertaMantenimientoDao.findById(alertaMantenimiento.getIdAlerta()).orElse(null);
    }

   
    @Transactional
    @Override
    public void guardar(AlertaMantenimiento alertaMantenimiento) {
        alertaMantenimientoDao.save(alertaMantenimiento);
    
    }
    
    @Transactional
    @Override
    public void eliminar(AlertaMantenimiento alertaMantenimiento) {
        alertaMantenimientoDao.delete(alertaMantenimiento);
    
}

     */
    @Override
    @Transactional(readOnly = true)
    public List<AlertaMantenimiento> listarAlertaMantenimientos() {
        return alertasMantenimientoRepositoryImpl.getAlertas();
    }

    @Override
    @Transactional(readOnly = true)
    public AlertaMantenimiento encontrarAlertaMantenimiento(AlertaMantenimiento alertaMantenimiento) {
        return alertaMantenimientoDao.findById(alertaMantenimiento.getIdAlerta()).orElse(null);
    }

    @Transactional
    @Override
    public void guardar(AlertaMantenimiento alertaMantenimiento) {
       try {
      
        if (alertaMantenimiento.getIdAlerta() == null) {
            alertaMantenimientoDao.insertarAlertas(
                    alertaMantenimiento.getEquipo().getIdEquipo(),
                    alertaMantenimiento.getFechaAlerta(), 
                    alertaMantenimiento.getMotivo(),
                    alertaMantenimiento.getEstado().getIdEstado());
        } else {
            alertaMantenimientoDao.actualizarAlertas(
                    alertaMantenimiento.getIdAlerta(),
                    alertaMantenimiento.getEquipo().getIdEquipo(),
                    alertaMantenimiento.getFechaAlerta(),
                    alertaMantenimiento.getMotivo(),
                    alertaMantenimiento.getEstado().getIdEstado());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Transactional
    @Override
    public void eliminar(AlertaMantenimiento alertaMantenimiento) {
        alertaMantenimientoDao.eliminarAlertas(alertaMantenimiento.getIdAlerta());

    }
}
