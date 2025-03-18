/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;
import com.EquiposMedicos.domain.Equipos;
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
@RequestMapping("/equipos")
public class EquiposController {
    @Autowired
    private EquiposService equiposService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var equiposs = equiposService.listarEquiposs();
        model.addAttribute("equiposs", equiposs);
        model.addAttribute("totalEquiposs", equiposs.size());
        model.addAttribute("equipos", new Equipos());
        return "equipos/listado";
    }
    
    @GetMapping("/nuevo")
    public String equiposNuevo(Equipos equipos) {
        return "equipos/modifica";
    }
    
    @PostMapping("/guardar")
    public String equiposGuardar(Equipos equipos) {
        equiposService.guardar(equipos);
        return "redirect:/equipos/listado";
    }
    
    @GetMapping("/eliminar/{idEquipos}")
    public String equiposEliminar(Equipos equipos) {
        equiposService.eliminar(equipos);
        return "redirect:/equipos/listado";
    }
    
    @GetMapping("/modificar/{idEquipos}")
    public String equiposModificar(Equipos equipos, Model model) {
        equipos = equiposService.encontrarEquipos(equipos);
        model.addAttribute("equipos", equipos);
        return "equipos/modifica";
    }
    
}
