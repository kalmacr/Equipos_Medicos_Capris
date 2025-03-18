package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.AlertaMantenimiento;
import java.util.List;


/**
 *
 * @author kcalm
 */
public interface AlertaMantenimientoService {

    
    List<AlertaMantenimiento> listarAlertaMantenimientos();
    AlertaMantenimiento encontrarAlertaMantenimiento(AlertaMantenimiento alertaMantenimiento);
    void eliminar(AlertaMantenimiento alertaMantenimiento);
    void guardar(AlertaMantenimiento alertaMantenimiento);

}
