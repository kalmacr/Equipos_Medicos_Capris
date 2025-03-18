/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.HistorialSoluciones;
import com.EquiposMedicos.service.HistorialSolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/historial-soluciones")
public class HistorialSolucionesController {

    @Autowired
    private HistorialSolucionesService historialSolucionesService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var historialSoluciones = historialSolucionesService.getHistorialSoluciones(false);
        model.addAttribute("historialSoluciones", historialSoluciones);
        model.addAttribute("totalHistorialSoluciones", historialSoluciones.size());
        model.addAttribute("historialSolucion", new HistorialSoluciones());
        return "historial-soluciones/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("historialSolucion") HistorialSoluciones historialSolucion) {
        historialSolucionesService.saveHistorialSolucion(historialSolucion);
        return "redirect:/historial-soluciones/listado";
    }

    @GetMapping("/eliminar/{idHistorialSolucion}")
    public String eliminar(@PathVariable Long idHistorialSolucion) {
        historialSolucionesService.deleteHistorialSolucion(idHistorialSolucion);
        return "redirect:/historial-soluciones/listado";
    }
}
