/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

/**
 *
 * @author Fabián Vargas
 */
import com.EquiposMedicos.domain.PrioridadError;
import com.EquiposMedicos.service.PrioridadErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prioridad")
public class PrioridadErrorController {
    @Autowired
    private PrioridadErrorService prioridadService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var prioridades = prioridadService.listarPrioridades();
        model.addAttribute("prioridades", prioridades);
        model.addAttribute("totalPrioridades", prioridades.size());
        model.addAttribute("prioridad", new PrioridadError());
        return "prioridad/listado";
    }
    
    @GetMapping("/nuevo")
    public String prioridadNuevo(PrioridadError prioridad) {
        return "prioridad/modifica";
    }
    
    @PostMapping("/guardar")
    public String prioridadGuardar(PrioridadError prioridad) {
        prioridadService.guardar(prioridad);
        return "redirect:/prioridad/listado";
    }
    
    @GetMapping("/eliminar/{idPrioridad}")
    public String prioridadEliminar(PrioridadError prioridad) {
        prioridadService.eliminar(prioridad);
        return "redirect:/prioridad/listado";
    }
    
    @GetMapping("/modificar/{idPrioridad}")
    public String prioridadModificar(PrioridadError prioridad, Model model) {
        prioridad = prioridadService.encontrarPrioridad(prioridad);
        model.addAttribute("prioridad", prioridad);
        return "prioridad/modifica";
    }
    
}
