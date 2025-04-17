/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.Ubicacion;
import com.EquiposMedicos.service.CentroService;
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
@RequestMapping("/ubicaciones")
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;
    
    @Autowired
    private CentroService centroService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var ubicacions = ubicacionService.listarUbicacions();
        var centros = centroService.listarCentros(); 
        model.addAttribute("centros", centros); 
        model.addAttribute("ubicacions", ubicacions);
        model.addAttribute("totalUbicacions", ubicacions.size());
        model.addAttribute("ubicacion", new Ubicacion());
        return "ubicaciones/listado";
    }

    @GetMapping("/nuevo")
    public String ubicacionNuevo(Ubicacion ubicacion, Model model) {
        var centros = centroService.listarCentros(); // Obtén la lista de centros
        model.addAttribute("centros", centros); // Agrega la lista al modelo
        return "ubicaciones/modifica";
    }

    @PostMapping("/guardar")
    public String ubicacionGuardar(Ubicacion ubicacion) {
        
        ubicacionService.guardar(ubicacion);
        return "redirect:/ubicaciones/listado";
    }

    @GetMapping("/eliminar/{idUbicacion}")
    public String ubicacionEliminar(Ubicacion ubicacion) {
        ubicacionService.eliminar(ubicacion);
        return "redirect:/ubicaciones/listado";
    }

    @GetMapping("/modificar/{idUbicacion}")
    public String ubicacionModificar(Ubicacion ubicacion, Model model) {
        model.addAttribute("centros", centroService.listarCentros()); 
        ubicacion = ubicacionService.encontrarUbicacion(ubicacion);
        model.addAttribute("ubicacion", ubicacion);
        return "ubicaciones/modifica";
    }
    
}