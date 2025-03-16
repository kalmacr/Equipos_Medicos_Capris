/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

/**
 *
 * @author Fabián Vargas
 */
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estado")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var estados = estadoService.listarEstados();
        model.addAttribute("estados", estados);
        model.addAttribute("totalEstados", estados.size());
        model.addAttribute("estado", new Estado());
        return "estado/listado";
    }
    
    @GetMapping("/listado/{tipoEstado}")
    public String listadoPorTipo(@PathVariable String tipoEstado, Model model) {
        var estados = estadoService.listarEstadosPorTipo(tipoEstado);
        model.addAttribute("estados", estados);
        model.addAttribute("totalEstados", estados.size());
        model.addAttribute("tipoEstado", tipoEstado);
        model.addAttribute("estado", new Estado());
        return "estado/listado";
    }
    
    @GetMapping("/nuevo")
    public String estadoNuevo(Estado estado) {
        return "estado/modifica";
    }
    
    @GetMapping("/nuevo/{tipoEstado}")
    public String estadoNuevoTipo(@PathVariable String tipoEstado, Model model) {
        Estado estado = new Estado();
     //   estado.setTipoEstado(tipoEstado);
        model.addAttribute("estado", estado);
        return "estado/modifica";
    }
    
    @PostMapping("/guardar")
    public String estadoGuardar(Estado estado) {
        estadoService.guardar(estado);
        return "redirect:/estado/listado";
    }
    
    @GetMapping("/eliminar/{idEstado}")
    public String estadoEliminar(Estado estado) {
        estadoService.eliminar(estado);
        return "redirect:/estado/listado";
    }
    
    @GetMapping("/modificar/{idEstado}")
    public String estadoModificar(Estado estado, Model model) {
       // estado = estadoService.encontrarEstado(estado);
        model.addAttribute("estado", estado);
        return "estado/modifica";
    }
    
}
