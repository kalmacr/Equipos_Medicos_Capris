/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.Diagnosticos;
import com.EquiposMedicos.service.DiagnosticosService;
import com.EquiposMedicos.service.EquiposService;
import com.EquiposMedicos.service.ErroresService;
import com.EquiposMedicos.service.SolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/diagnosticos")
public class DiagnosticosController {

    @Autowired
    private DiagnosticosService diagnosticosService;
    @Autowired
    private EquiposService equipoService;
    @Autowired
    private ErroresService erroresService;
    @Autowired
    private SolucionesService solucionesService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var diagnosticos = diagnosticosService.getDiagnosticos(false);
        var equipos = equipoService.listarEquiposs();
        var errores = erroresService.getErrores(true);
        var soluciones = solucionesService.getSoluciones();

        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("diagnostico", new Diagnosticos());
        model.addAttribute("equipos", equipos);
        model.addAttribute("errores", errores);
        model.addAttribute("soluciones", soluciones);
        return "diagnosticos/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoDiagnostico(Model model) {
        model.addAttribute("diagnostico", new Diagnosticos());
        return "diagnosticos/modifica";
    }

    @GetMapping("/modificar/{idDiagnostico}")
    public String editar(Diagnosticos diagnostico, Model model) {
        diagnostico = diagnosticosService.getDiagnosticoById(diagnostico.getIdDiagnostico());
        var equipos = equipoService.listarEquiposs();
        var errores = erroresService.getErrores(true);
        var soluciones = solucionesService.getSoluciones();
        model.addAttribute("equipos", equipos);
        model.addAttribute("errores", errores);
        model.addAttribute("soluciones", soluciones);
        model.addAttribute("diagnostico", diagnostico);
        return "diagnosticos/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("diagnostico") Diagnosticos diagnostico) {
        diagnosticosService.saveDiagnostico(diagnostico);
        return "redirect:/diagnosticos/listado";
    }

    @GetMapping("/eliminar/{idDiagnostico}")
    public String eliminar(@PathVariable Long idDiagnostico) {
        diagnosticosService.deleteDiagnostico(idDiagnostico);
        return "redirect:/diagnosticos/listado";
    }
}
