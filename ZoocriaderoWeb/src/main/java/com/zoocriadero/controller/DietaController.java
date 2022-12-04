/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.zoocriadero.controller;

import com.zoocriadero.domain.Dieta;
import com.zoocriadero.domain.Especie;
import com.zoocriadero.service.DietaService;
import com.zoocriadero.service.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Yohan Alvarado
 */
@Controller
public class DietaController {

    @Autowired
    private EspecieService especieService;

    @Autowired
    private DietaService dietaService;

    @RequestMapping("/dieta/index")
    public String page(Model model) {

        var listEspecies = especieService.getEspecies();
        Especie especie = new Especie();
        especie.setIdEspecie(listEspecies.get(0).getIdEspecie());
        model.addAttribute("listEspecies", listEspecies);
        model.addAttribute("especie", especie);

        return "/dieta/index";
    }

    @PostMapping("/dieta/habilitarEventos")
    public String nuevaInvestigacion(Model model, Especie especie) {

        var listEspecies = especieService.getEspecies();

        model.addAttribute("listEspecies", listEspecies);
        model.addAttribute("especie", especie);

        return "/dieta/index";
    }

    @GetMapping("/dieta/nueva/{idEspecie}")
    public String nuevaDieta(Model model, Especie especie) {
        Dieta dieta = new Dieta();
        dieta.setEspecie(especie);
        model.addAttribute("dieta", dieta);
        return "/dieta/modificar";

    }

    @PostMapping("/dieta/guardarDieta")
    public String guardarDieta(Model model, Dieta dieta) {

        dietaService.save(dieta);

        return "redirect:/dieta/leer/"+dieta.getEspecie().getIdEspecie();
    }

    @GetMapping("/dieta/leer/{idEspecie}")
    public String leerDieta(Model model, Especie especie) {

        var dietas = dietaService.getDietas(especie.getIdEspecie());

        model.addAttribute("dietas", dietas);
        return "/dieta/leer";

    }

    @GetMapping("/dieta/modificar/{idEspecie}")
    public String modificarDieta(Model model, Especie especie) {
        Dieta dieta = new Dieta();

        var dietas = dietaService.getDietas(especie.getIdEspecie());

        if (dietas.size() == 0) {
            return "redirect:/dieta/index/";
        }

        dieta.setEspecie(especie);

        for (Dieta var : dietas) {
            dieta.setIdDieta(var.getIdDieta());
            dieta.setAlimento(var.getAlimento());
            dieta.setPeso(var.getPeso());
            dieta.setCalorias(var.getCalorias());
            dieta.setCantidad(var.getCantidad());
            dieta.setFecha(var.getFecha());
        }

        model.addAttribute("dieta", dieta);

        return "/dieta/modificar";

    }

    @GetMapping("/dieta/eliminar/{idEspecie}")
    public String eliminarDieta(Especie especie) {

        Dieta dieta = new Dieta();

        var dietas = dietaService.getDietas(especie.getIdEspecie());

        if (dietas.size() == 0) {
            return "redirect:/dieta/index/";
        }

        dieta.setEspecie(especie);

        for (Dieta var : dietas) {
            dieta.setIdDieta(var.getIdDieta());
            dieta.setAlimento(var.getAlimento());
            dieta.setPeso(var.getPeso());
            dieta.setCalorias(var.getCalorias());
            dieta.setCantidad(var.getCantidad());
            dieta.setFecha(var.getFecha());
        }

        dietaService.delete(dieta);
        return "redirect:/dieta/index/";
    }
}
