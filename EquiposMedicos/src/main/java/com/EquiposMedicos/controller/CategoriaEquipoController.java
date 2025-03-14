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
import com.EquiposMedicos.service.CategoriaEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categoria")
public class CategoriaEquipoController {
    
    @Autowired
    private CategoriaEquipoService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        model.addAttribute("categoria", new CategoriaEquipo());
        return "categoria/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(CategoriaEquipo categoria) {
        return "categoria/modifica";
    }
    
    @PostMapping("/guardar")
    public String categoriaGuardar(CategoriaEquipo categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/eliminar/{idCategoria}")
    public String categoriaEliminar(CategoriaEquipo categoria) {
        categoriaService.eliminar(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(CategoriaEquipo categoria, Model model) {
        categoria = categoriaService.encontrarCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "categoria/modifica";
    }
    
}
