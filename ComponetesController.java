/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;
import com.EquiposMedicos.domain.Componentes;
import com.EquiposMedicos.service.ComponentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Chope2805
 */
public class ComponetesController {
   @Controller
@RequestMapping("/componetes")
public class ComponentesController {
    @Autowired
    private ComponentesService componetesService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var componetess = componetesService.listarComponentess();
        model.addAttribute("componetess", componetess);
        model.addAttribute("totalComponentess", componetess.size());
        model.addAttribute("componetes", new Componentes());
        return "componetes/listado";
    }
    
    @GetMapping("/nuevo")
    public String componetesNuevo(Componentes componetes) {
        return "componetes/modifica";
    }
    
    @PostMapping("/guardar")
    public String componetesGuardar(Componentes componetes) {
        componetesService.guardar(componetes);
        return "redirect:/componetes/listado";
    }
    
    @GetMapping("/eliminar/{idComponentes}")
    public String componetesEliminar(Componentes componetes) {
        componetesService.eliminar(componetes);
        return "redirect:/componetes/listado";
    }
    
    @GetMapping("/modificar/{idComponentes}")
    public String componetesModificar(Componentes componetes, Model model) {
        componetes = componetesService.encontrarComponentes(componetes);
        model.addAttribute("componetes", componetes);
        return "componetes/modifica";
    }
    
}
 
}
