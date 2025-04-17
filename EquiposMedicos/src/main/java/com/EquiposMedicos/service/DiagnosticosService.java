/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.service;

import com.EquiposMedicos.domain.Diagnosticos;
import java.util.List;

public interface DiagnosticosService {
    List<Diagnosticos> getDiagnosticos(boolean activos);
    List<Diagnosticos> listarPorEquipo(Long idEquipo);
    Diagnosticos getDiagnosticoById(Long idDiagnostico);
    void saveDiagnostico(Diagnosticos diagnostico);
    void deleteDiagnostico(Long idDiagnostico);
}
