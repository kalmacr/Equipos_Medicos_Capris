/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.domain.Usuario;
import com.EquiposMedicos.service.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Fabián Vargas
 */

@Controller
@RequestMapping("/usuario")
public class UsuariosController {
    
    @Autowired
    private UsuariosServices usuarioService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var usuarios = usuarioService.getUsuarios(false);
        model.addAttribute("usuarios", usuarios);  
        model.addAttribute("totalUsuarios", usuarios.size());
        model.addAttribute("usuario", new Usuario()); 
        return "usuario/listado"; 
    }
    
    @GetMapping("/nuevo")
    public String usuarioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/modifica";  
    }
    
    @PostMapping("/guardar")
    public String usuarioGuardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/listado";
    }
    
    @GetMapping("/eliminar/{idUsuario}")
    public String usuarioEliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/listado";
    }
    
    @GetMapping("/modificar/{idUsuario}")
    public String usuarioModificar(Usuario usuario, Model model) {
       // usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "usuario/modifica"; 
    }
    
}
