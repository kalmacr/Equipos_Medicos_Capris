/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.DiagnosticosDao;
import com.EquiposMedicos.dao.DiagnosticosRepositoryImpl;
import com.EquiposMedicos.domain.Diagnosticos;
import com.EquiposMedicos.service.DiagnosticosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticosServiceImpl implements DiagnosticosService {

    @Autowired
    private DiagnosticosDao diagnosticosDao;
    
    @Autowired
    private DiagnosticosRepositoryImpl diagnosticosRepositoryImpl;
      
    /*
    @Override
    public List<Diagnosticos> getDiagnosticos(boolean activos) {
        var lista = diagnosticosDao.findAll();
        // Aquí puedes agregar lógica adicional si es necesario
        return lista;
    }

    @Override
    public Diagnosticos getDiagnosticoById(Long idDiagnostico) {
        return diagnosticosDao.findById(idDiagnostico).orElse(null);
    }

    @Override
    public void saveDiagnostico(Diagnosticos diagnostico) {
        diagnosticosDao.save(diagnostico);
    }

    @Override
    public void deleteDiagnostico(Long idDiagnostico) {
        diagnosticosDao.deleteById(idDiagnostico);
    }
*/
    
    @Override
    public List<Diagnosticos> getDiagnosticos(boolean activos) {
        var lista = diagnosticosRepositoryImpl.getDiagnosticos();
        // Aquí puedes agregar lógica adicional si es necesario
        return lista;
    }

    @Override
    public Diagnosticos getDiagnosticoById(Long idDiagnostico) {
        return diagnosticosDao.findById(idDiagnostico).orElse(null);
    }

    @Override
    public void saveDiagnostico(Diagnosticos diagnostico) {
        if(diagnostico.getIdDiagnostico() == null){
            java.util.Date fechaUtil = diagnostico.getFecha();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            diagnosticosDao.insertarEquipo(diagnostico.getEquipo().getIdEquipo(),
                    fechaSql , diagnostico.getDescripcionProblema(),
                    diagnostico.getError().getIdError(), diagnostico.getSolucion().getIdSolucion());
        }else
        {
            java.util.Date fechaUtil = diagnostico.getFecha();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            diagnosticosDao.actualizarEquipo(diagnostico.getIdDiagnostico(), 
                    diagnostico.getEquipo().getIdEquipo(),
                    fechaSql , diagnostico.getDescripcionProblema(),
                    diagnostico.getError().getIdError(), diagnostico.getSolucion().getIdSolucion());
        }
    }

    @Override
    public void deleteDiagnostico(Long idDiagnostico) {
        diagnosticosDao.eliminarEquipo(idDiagnostico);
    }
    
    @Override
    public List<Diagnosticos> listarPorEquipo(Long idEquipo) {
        return diagnosticosDao.findByEquipo_IdEquipo(idEquipo);
    }
    
}
