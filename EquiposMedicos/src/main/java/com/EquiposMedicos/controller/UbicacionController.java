/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.Ubicacion;
import com.EquiposMedicos.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Chope2805
 */

   @Controller
@RequestMapping("/ubicacion")
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var ubicacions = ubicacionService.listarUbicacions();
        model.addAttribute("ubicacions", ubicacions);
        model.addAttribute("totalUbicacions", ubicacions.size());
        model.addAttribute("ubicacion", new Ubicacion());
        return "ubicacion/listado";
    }
    
    @GetMapping("/nuevo")
    public String ubicacionNuevo(Ubicacion ubicacion) {
        return "ubicacion/modifica";
    }
    
    @PostMapping("/guardar")
    public String ubicacionGuardar(Ubicacion ubicacion) {
        ubicacionService.guardar(ubicacion);
        return "redirect:/ubicacion/listado";
    }
    
    @GetMapping("/eliminar/{idUbicacion}")
    public String ubicacionEliminar(Ubicacion ubicacion) {
        ubicacionService.eliminar(ubicacion);
        return "redirect:/ubicacion/listado";
    }
    
    @GetMapping("/modificar/{idUbicacion}")
    public String ubicacionModificar(Ubicacion ubicacion, Model model) {
        ubicacion = ubicacionService.encontrarUbicacion(ubicacion);
        model.addAttribute("ubicacion", ubicacion);
        return "ubicacion/modifica";
    }
    
}