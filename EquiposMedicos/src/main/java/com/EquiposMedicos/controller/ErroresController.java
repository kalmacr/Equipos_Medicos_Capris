/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;


import com.EquiposMedicos.domain.Errores;
import com.EquiposMedicos.domain.Usuario;
import com.EquiposMedicos.service.ErroresService;
import com.EquiposMedicos.service.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/errores")
public class ErroresController {

    @Autowired
    private ErroresService erroresService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var errores = erroresService.getErrores(false);
        model.addAttribute("errores", errores);
        model.addAttribute("totalErrores", errores.size());
        model.addAttribute("error", new Errores());
        return "errores/listado";
    }
    
    @GetMapping("/nuevo")
    public String nuevoError(Model model) {
        model.addAttribute("error", new Errores());
        return "errores/agregarError";
    }
    
    @GetMapping("/editar/{idError}")
    public String editar(Errores error, Model model) {
        error = erroresService.getError(error);
        model.addAttribute("error", error);
        return "errores/modifica";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("error") Errores error) {
        erroresService.saveError(error);
        return "redirect:/errores/listado";
    }
    
    @GetMapping("/eliminar/{idError}")
    public String eliminar(@PathVariable Long idError) {
        erroresService.deleteError(idError);
        return "redirect:/errores/listado";
    }
}
