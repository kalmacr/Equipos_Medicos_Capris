/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import com.EquiposMedicos.dao.EquipoDao;
import com.EquiposMedicos.dao.EstadoDao;
import com.EquiposMedicos.domain.AlertaMantenimiento;
import com.EquiposMedicos.domain.Equipo;
import com.EquiposMedicos.domain.Estado;
import com.EquiposMedicos.service.AlertaMantenimientoService;
import com.EquiposMedicos.service.EquiposService;
import com.EquiposMedicos.service.EstadoService;
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
@RequestMapping("/alertaMantenimiento")
public class AlertaMantenimientoController {

    @Autowired
    private AlertaMantenimientoService alertaMantenimientoService;
    @Autowired
    private EquipoDao equipoDao;
    
    @Autowired
    private EstadoDao estadoDao;
    
    @Autowired
    private EquiposService equiposService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var alertas = alertaMantenimientoService.listarAlertaMantenimientos();
        List<Estado>Estados = estadoDao.findAll();
        List<Equipo>equipos = equiposService.listarEquiposs();
        System.out.println("Estados compro 1112 cargados: " + equipos);
        model.addAttribute("Estados", Estados);
        model.addAttribute("Equipos", equipos); 
        model.addAttribute("alertasMantenimiento", alertas);
        model.addAttribute("totalAlertas", alertas.size());
        model.addAttribute("alertaMantenimiento", new AlertaMantenimiento());
        
        return "alertaMantenimiento/listado";
    }

    @GetMapping("/nuevo")
    public String alertasNuevo(Model model) {
        List<Estado>Estados = estadoDao.findAll();
        List<Equipo>Equipos = equipoDao.findAll();
        model.addAttribute("Equipos", Equipos);
        model.addAttribute("Estados", Estados); // Añade los estados al modelo
        model.addAttribute("alertaMantenimiento", new AlertaMantenimiento());
        System.out.println("Estados compro 1112 cargados: " + Estados);

        return "alertaMantenimiento/modifica";
    }

    @PostMapping("/guardar")
    public String alertaGuardar(@ModelAttribute AlertaMantenimiento alertaMantenimiento) {
        alertaMantenimientoService.guardar(alertaMantenimiento);
        return "redirect:/alertaMantenimiento/listado";
    }

    @GetMapping("/eliminar/{idAlerta}")
    public String alertaMantenimientoEliminar(AlertaMantenimiento alertaMantenimiento) {
        alertaMantenimientoService.eliminar(alertaMantenimiento);
        return "redirect:/alertaMantenimiento/listado";
    }

    @GetMapping("/modificar/{idAlerta}")
    public String alertaMantenimientoModificar(AlertaMantenimiento alertaMantenimiento, Model model) {
        List<Estado>Estados = estadoDao.findAll();
        List<Equipo>Equipos = equipoDao.findAll();
        model.addAttribute("Equipos", Equipos);
        model.addAttribute("Estados", Estados);
        alertaMantenimiento = alertaMantenimientoService.encontrarAlertaMantenimiento(alertaMantenimiento);
        model.addAttribute("alertaMantenimiento", alertaMantenimiento);
        return "alertaMantenimiento/modifica";
    }
}
