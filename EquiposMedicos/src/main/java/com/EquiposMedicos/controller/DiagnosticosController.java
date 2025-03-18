/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.Diagnosticos;
import com.EquiposMedicos.service.DiagnosticosService;
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

    @GetMapping("/listado")
    public String listado(Model model) {
        var diagnosticos = diagnosticosService.getDiagnosticos(false);
        model.addAttribute("diagnosticos", diagnosticos);
        model.addAttribute("totalDiagnosticos", diagnosticos.size());
        model.addAttribute("diagnostico", new Diagnosticos());
        return "diagnosticos/listado";
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
