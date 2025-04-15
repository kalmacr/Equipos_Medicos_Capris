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
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estado")
public class EstadoController {
    
    @Autowired
    private EstadoService estadoService;
  /*  
    @GetMapping("/listado")
    public String listado(Model model) {
        var estados = estadoService.listarEstados();
        System.out.println("Usuarios recuperados: " + estados);
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
    */
    
     @GetMapping("/listado")
    public String listado(Model model) {
        // Ahora usa el procedimiento get_estados a través del servicio
        var estados = estadoService.getEstados();
        System.out.println("Usuarios recuperados: " + estados);
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
        estado.setTipoEstado(tipoEstado); // Descomento esta línea para que funcione correctamente
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
        // Ahora usa el procedimiento eliminar_estado a través del servicio
        estadoService.eliminar(estado);
        return "redirect:/estado/listado";
    }
    
    @GetMapping("/modificar/{idEstado}")
    public String estadoModificar(Estado estado, Model model) {
       estado = estadoService.encontrarEstados(estado);
        model.addAttribute("estado", estado);
        return "estado/modifica";
    }
}
