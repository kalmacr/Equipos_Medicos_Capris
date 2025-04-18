package com.EquiposMedicos.controller;

import com.EquiposMedicos.dao.UsuariosDao;
import com.EquiposMedicos.domain.HistorialUsuario;
import com.EquiposMedicos.domain.Usuario;
import com.EquiposMedicos.service.HistorialUsuarioService;
import com.EquiposMedicos.service.UsuariosServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kcalm
 */
@Controller
@RequestMapping("/historialUsuario")
public class HistorialUsuarioController {

    @Autowired
    private HistorialUsuarioService historialUsuarioService;
    @Autowired
    private UsuariosServices usuarioService;


    @GetMapping("/listado")
    public String listado(Model model) {
        var historial = historialUsuarioService.listarHistorialUsuario();
        List<Usuario> Usuarios = usuarioService.getUsuarios(true);
        model.addAttribute("Usuarios", Usuarios);
        model.addAttribute("historialUsuarioList", historial);
        model.addAttribute("totalHistorialUsuario", historial.size());
        model.addAttribute("nuevoHistorialUsuario", new HistorialUsuario());

        return "historialUsuario/listado";
    }

    @GetMapping("/nuevo")
    public String historialNuevo(Model model) {
        List<Usuario> Usuarios = usuarioService.getUsuarios(true);
        model.addAttribute("Usuarios", Usuarios);
        model.addAttribute("historialUsuario", new HistorialUsuario());

        return "historialUsuario/listado";
    }

  

    @PostMapping("/guardar")
    public String historialUsuarioGuardar(@ModelAttribute HistorialUsuario historialUsuario) {
        historialUsuarioService.guardar(historialUsuario);
        return "redirect:/historialUsuario/listado";
    }

    @GetMapping("/eliminar/{idHistorial}")
    public String historialUsuarioEliminar(HistorialUsuario historialUsuario) {
        historialUsuarioService.eliminar(historialUsuario);
        return "redirect:/historialUsuario/listado";
    }

    @GetMapping("/modificar/{idHistorial}")
    public String historialUsuarioModificar(HistorialUsuario historialUsuario, Model model) {
        List<Usuario> Usuarios = usuarioService.getUsuarios(true);
        model.addAttribute("Usuarios", Usuarios);
        historialUsuario = historialUsuarioService.encontrarHistorialUsuario(historialUsuario);
        model.addAttribute("historialUsuario", historialUsuario);
        return "historialUsuario/modifica";
    }

}
