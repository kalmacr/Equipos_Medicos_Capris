package com.EquiposMedicos.controller;

import com.EquiposMedicos.dao.CategoriaEquipoDao;
import com.EquiposMedicos.dao.ErroresDao;
import com.EquiposMedicos.domain.CategoriaEquipo;
import com.EquiposMedicos.domain.Errores;
import com.EquiposMedicos.domain.ErroresPorCategoria;
import com.EquiposMedicos.service.CategoriaEquipoService;
import com.EquiposMedicos.service.ErroresPorCategoriaService;
import com.EquiposMedicos.service.ErroresService;
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
@RequestMapping("/erroresPorCategoria")
public class ErroresPorCategoriaController {

    @Autowired
    private ErroresPorCategoriaService erroresPorCategoriaService;
    @Autowired
    private CategoriaEquipoService categoriaService;
    
    @Autowired
    private ErroresService erroresService;
    
    @Autowired
    CategoriaEquipoDao categoriaEquipo;
    @Autowired
    ErroresDao erroresDao;

    @GetMapping("/listado")
    public String listado(Model model) {
        var listaErroresPorCategoria = erroresPorCategoriaService.listarErroresPorCategoria();
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        
        //List<Errores> Errores = erroresService.getErrores(false);
        List<Errores> Errores = erroresDao.findAll();
        model.addAttribute("Errores", Errores); // Añade los estados al modelo
        model.addAttribute("listaErroresPorCategoria", listaErroresPorCategoria);
        model.addAttribute("totalerroresPorCategoria", listaErroresPorCategoria.size());
        model.addAttribute("erroresPorCategoria", new ErroresPorCategoria());
     
        return "erroresPorCategoria/listado";
    }
        
    @GetMapping("/nuevo")
    public String historialNuevo(Model model) {
        List<Errores> Errores = erroresDao.findAll();
        model.addAttribute("Errores", Errores); // Añade los estados al modelo
        model.addAttribute("Errores", new ErroresPorCategoria());
        System.out.println("Estados compro 1112 cargados: " + Errores);

        return "erroresPorCategoria/listado";
    }

  

    @PostMapping("/guardar")
    public String Guardar(@ModelAttribute ErroresPorCategoria erroresPorCategoria) {
        erroresPorCategoriaService.guardar(erroresPorCategoria);
        return "redirect:/erroresPorCategoria/listado";
    }

    @GetMapping("/eliminar/{idErrorCategoria}")
    public String historialUsuarioEliminar(ErroresPorCategoria erroresPorCategoria) {
        erroresPorCategoriaService.eliminar(erroresPorCategoria);
        return "redirect:/erroresPorCategoria/listado";
    }

    @GetMapping("/modificar/{idErrorCategoria}")
    public String historialUsuarioModificar(ErroresPorCategoria erroresPorCategoria, Model model) {
        List<Errores> Errores = erroresDao.findAll();
        model.addAttribute("Errores", Errores);
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        erroresPorCategoria = erroresPorCategoriaService.erroresPorCategoria(erroresPorCategoria);
        model.addAttribute("historialUsuario", erroresPorCategoria);
        return "erroresPorCategoria/modifica";
    }
    }
    
    

    
    
    
    
    
    
    
    
    
    
    
//    @GetMapping("/listado")
//    @ResponseBody
//    public ResponseEntity<List<ErroresPorCategoria>> listado(){
//        var erroresPorCategoria = erroresPorCategoriaService.listarErroresPorCategoria();
//        System.err.println("Errores mostrar test: " + erroresPorCategoria);
//        return ResponseEntity.ok(erroresPorCategoria);
//
//
//    }


