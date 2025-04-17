/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

/**
 *
 * @author Fabián Vargas
 */
import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Centro;
import com.EquiposMedicos.domain.Equipo;
import com.EquiposMedicos.service.CategoriaEquipoService;
import com.EquiposMedicos.service.CentroService;
import com.EquiposMedicos.service.DiagnosticosService;
import com.EquiposMedicos.service.EquiposService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private CategoriaEquipoService categoriaEquipoService;

    @Autowired
    private EquiposService equipoService;

    @Autowired
    private DiagnosticosService diagnosticosService;

    @GetMapping("/")
    public String mostrarIndex(Model model) {
        model.addAttribute("categorias", categoriaEquipoService.listarCategorias());
        return "index";
    }

    @GetMapping("/categorias/seleccionar/{id}")
    public String seleccionarCategoria(@PathVariable("id") Long id, Model model) {
        var categoria = categoriaEquipoService.encontrarCategoriabyID(id);
        var equipos = equipoService.listarPorCategoria(id);

        model.addAttribute("categoriaSeleccionada", categoria);
        model.addAttribute("equipos", equipos);
        return "index";
    }

    @GetMapping("/equipos/seleccionar/{id}")
    public String seleccionarEquipo(@PathVariable("id") Long id, Model model) {
        var equipo = equipoService.encontrarEquiposbyId(id);
        var diagnosticos = diagnosticosService.listarPorEquipo(id);

        model.addAttribute("equipoSeleccionado", equipo);
        model.addAttribute("diagnosticos", diagnosticos);
        return "index";
    }

}
