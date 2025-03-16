/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

/**
 *
 * @author Fabián Vargas
 */
import com.EquiposMedicos.domain.Centro;
import com.EquiposMedicos.service.CentroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/centro")
public class CentroController {
    @Autowired
    private CentroService centroService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var centros = centroService.listarCentros();
        model.addAttribute("centros", centros);
        model.addAttribute("totalCentros", centros.size());
        model.addAttribute("centro", new Centro());
        return "centro/listado";
    }
    
    @GetMapping("/nuevo")
    public String centroNuevo(Centro centro) {
        return "centro/modifica";
    }
    
    @PostMapping("/guardar")
    public String centroGuardar(Centro centro) {
        centroService.guardar(centro);
        return "redirect:/centro/listado";
    }
    
    @GetMapping("/eliminar/{idCentro}")
    public String centroEliminar(Centro centro) {
        centroService.eliminar(centro);
        return "redirect:/centro/listado";
    }
    
    @GetMapping("/modificar/{idCentro}")
    public String centroModificar(Centro centro, Model model) {
        //centro = centroService.encontrarCentro(centro);
        model.addAttribute("centro", centro);
        return "centro/modifica";
    }
    
}
