/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.Soluciones;
import com.EquiposMedicos.domain.Soluciones;
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
@RequestMapping("/soluciones")
public class SolucionesController {

    @Autowired
    private SolucionesService solucionesService;
    
    @Autowired
    private ErroresService erroresService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var soluciones = solucionesService.getSoluciones();
        var errores = erroresService.getErrores(true);
        model.addAttribute("soluciones", soluciones);
        model.addAttribute("errores", errores);
        model.addAttribute("totalSoluciones", soluciones.size());
        model.addAttribute("solucion", new Soluciones());
        return "soluciones/listado";
    }
    
     @GetMapping("/nuevo")
    public String nuevoSolucion(Model model) {
        model.addAttribute("solucion", new Soluciones());
         var errores = erroresService.getErrores(true);
             model.addAttribute("errores", errores);

        return "soluciones/modifica";
    }
    
    @GetMapping("/modificar/{idSolucion}")
    public String editar(Soluciones solucion, Model model) {
        solucion = solucionesService.getSolucionById(solucion.getIdSolucion());
        var errores = erroresService.getErrores(true);
             model.addAttribute("errores", errores);
        model.addAttribute("solucion", solucion);
        return "soluciones/modifica";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("solucion") Soluciones solucion) {
        solucionesService.saveSolucion(solucion);
        return "redirect:/soluciones/listado";
    }

    @GetMapping("/eliminar/{idSolucion}")
    public String eliminar(@PathVariable Long idSolucion) {
        solucionesService.deleteSolucion(idSolucion);
        return "redirect:/soluciones/listado";
    }
}