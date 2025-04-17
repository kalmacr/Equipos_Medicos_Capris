/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.Componentes;
import com.EquiposMedicos.service.ComponentesService;
import com.EquiposMedicos.service.EquiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Chope2805
 */

   @Controller
@RequestMapping("/componentes")
public class ComponetesController {
    
    @Autowired
private ComponentesService componetesService;
    @Autowired
private EquiposService equiposService;
    
      @GetMapping("/listado")
    public String listado(Model model) {
        var componentesList = componetesService.listarComponentess();
        var equipos = equiposService.listarEquiposs();
        model.addAttribute("componentesList", componentesList);
        model.addAttribute("totalComponentes", componentesList.size());
        model.addAttribute("componentes", new Componentes());
        model.addAttribute("equipos", equipos);
        return "componentes/listado";
    }

    @GetMapping("/nuevo")
    public String componentesNuevo(Componentes componentes) {
        return "componentes/modifica";
    }

    @PostMapping("/guardar")
    public String componentesGuardar(Componentes componentes) {
        componetesService.guardar(componentes);
        return "redirect:/componentes/listado";
    }
    
    @GetMapping("/eliminar/{idComponente}")
    public String componetesEliminar(Componentes componetes) {
        componetesService.eliminar(componetes);
        return "redirect:/componentes/listado";
    }
    
    @GetMapping("/modificar/{idComponente}")
    public String componetesModificar(Componentes componetes, Model model) {
        componetes = componetesService.encontrarComponentes(componetes);
        model.addAttribute("componetes", componetes);
        model.addAttribute("equipos", equiposService.listarEquiposs());
        return "componentes/modifica";
    }
    
}
 
