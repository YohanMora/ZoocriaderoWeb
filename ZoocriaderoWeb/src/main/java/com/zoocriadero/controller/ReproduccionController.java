/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.zoocriadero.controller;


import com.zoocriadero.domain.Reproduccion;
import com.zoocriadero.service.EspecieService;
import com.zoocriadero.service.ReproduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yohan Alvarado
 */
@Controller
public class ReproduccionController {
    
    @Autowired
    ReproduccionService reproduccionService;
    @Autowired
    EspecieService especieService;
    
    
    @RequestMapping("/reproduccion/index")
    public String page(Model model) {
        var list = reproduccionService.getReproducciones();
        
        model.addAttribute("listaReproduciones", list);
        return "/reproduccion/index";
    }
    
    @GetMapping("/reproduccion/nuevo")
    public String nuevoReproduccion (Reproduccion reproduccion, Model model){
        var listEspecies = especieService.getEspecies();
        
        model.addAttribute("listEspecies", listEspecies);
        return "/reproduccion/modificar";
    }
    @PostMapping("/reproduccion/guardar")
    public String guardarReproduccion(Reproduccion reproduccion){
        reproduccionService.save(reproduccion);
        return "redirect:/reproduccion/index";
    }
    
    @GetMapping("/reproduccion/modificar/{idReproduccion}")
    public String modificarReproduccion(Reproduccion reproduccion, Model model){
        reproduccion = reproduccionService.getReproduccion(reproduccion);
        
        var listEspecies = especieService.getEspecies();
        listEspecies.clear();
        model.addAttribute("listEspecies", listEspecies);
        
        model.addAttribute("reproduccion", reproduccion);
        return "/reproduccion/modificar";
    }
    @GetMapping("/reproduccion/eliminar/{idReproduccion}")
    public String eliminarReproduccion(Reproduccion reproduccion){
        reproduccionService.delete(reproduccion);
        return "redirect:/reproduccion/index";
    }
}
