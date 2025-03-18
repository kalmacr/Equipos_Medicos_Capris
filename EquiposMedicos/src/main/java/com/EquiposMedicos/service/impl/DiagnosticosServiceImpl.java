/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service.impl;

import com.EquiposMedicos.dao.DiagnosticosDao;
import com.EquiposMedicos.domain.Diagnosticos;
import com.EquiposMedicos.service.DiagnosticosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticosServiceImpl implements DiagnosticosService {

    @Autowired
    private DiagnosticosDao diagnosticosDao;

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
}
