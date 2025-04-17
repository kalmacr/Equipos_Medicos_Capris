/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Equipo;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.domain.Ubicacion;
import com.EquiposMedicos.service.CategoriaEquipoService;
import com.EquiposMedicos.service.CentroService;
import com.EquiposMedicos.service.EquiposService;
import com.EquiposMedicos.service.EstadoService;
import com.EquiposMedicos.service.UbicacionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    @Autowired
    private UbicacionService ubicacionService;
    @Autowired
    private CategoriaEquipoService categoriaEquipoService;
    @Autowired
    private EstadoService estadoService;
    
    @Autowired
    private CentroService centroService;

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Ubicacion> ubicaciones = ubicacionService.listarUbicacions();
        List<CategoriaEquipo> categorias = categoriaEquipoService.listarCategorias();
        List<Estado> estados = estadoService.getEstados();
        List<Equipo> equipos = equiposService.listarEquiposs();
        model.addAttribute("ubicaciones", ubicaciones);
        model.addAttribute("categorias", categorias);
        model.addAttribute("equipos", equipos);
        model.addAttribute("estados", estados);
        model.addAttribute("totalEquipos", equipos.size());
        return "equipos/listado";
    }

    @GetMapping("/nuevo")
    public String equiposNuevo(Model model) {
        List<Ubicacion> ubicaciones = ubicacionService.listarUbicacions();
        List<CategoriaEquipo> categorias = categoriaEquipoService.listarCategorias();
        List<Estado> estados = estadoService.getEstados();
        model.addAttribute("ubicaciones", ubicaciones);
        model.addAttribute("categorias", categorias);
        model.addAttribute("estados", estados);
        model.addAttribute("equipo", new Equipo());
        return "equipos/modifica";
    }

    @PostMapping("/guardar")
    public String equiposGuardar(
            @RequestParam String nombre,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String fabricante,
            @RequestParam(required = false) String numeroSerie,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaAdquisicion,
            @RequestParam Long ubicacion,
            @RequestParam Long categoriaEquipo,
            @RequestParam(required = false) Long estado) {
        
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setTipo(tipo);
        equipo.setFabricante(fabricante);
        equipo.setNumeroSerie(numeroSerie);
        equipo.setFechaAdquisicion(fechaAdquisicion);
        
        // Configurar ubicación
        Ubicacion ubicacionObj = new Ubicacion();
        ubicacionObj.setIdUbicacion(ubicacion);
        equipo.setUbicacion(ubicacionObj);
        
        // Configurar categoría
        CategoriaEquipo categoriaObj = new CategoriaEquipo();
        categoriaObj.setIdCategoria(categoriaEquipo);
        equipo.setCategoriaEquipo(categoriaObj);
        
        // Configurar estado si existe
        if (estado != null) {
            Estado estadoObj = new Estado();
            estadoObj.setIdEstado(estado);
            equipo.setEstado(estadoObj);
        }
        
        equiposService.guardar(equipo);
        return "redirect:/equipos/listado";
    }

    @GetMapping("/eliminar/{idEquipos}")
    public String equiposEliminar(@PathVariable("idEquipos") Long idEquipo) {
        Equipo equipo = new Equipo();
        equipo.setIdEquipo(idEquipo);
        equiposService.eliminar(equipo);
        return "redirect:/equipos/listado";
    }

    @GetMapping("/modificar/{idEquipo}")
    public String equiposModificar(Equipo equipo, Model model) {

        Equipo equipoEncontrado = equiposService.encontrarEquipos(equipo);
        model.addAttribute("equipo", equipoEncontrado);
        model.addAttribute("ubicaciones", ubicacionService.listarUbicacions());
        model.addAttribute("categorias", categoriaEquipoService.listarCategorias());
        model.addAttribute("estados", estadoService.getEstados());
        System.out.println("Entro a modifca");
        return "equipos/modifica";
    }

    @PostMapping("/actualizar")
public String equiposActualizar(@ModelAttribute Equipo equipo) {
    equiposService.guardar(equipo);
    return "redirect:/equipos/listado";
}
}