
package com.zoocriadero.controller;


import com.zoocriadero.domain.HistorialClinico;
import com.zoocriadero.service.HistorialClinicoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HistorialClinicoController {
    @Autowired
    private HistorialClinicoService historialClinicoService;
    @GetMapping("/historialClinico/index")
    public String inicio(Model model){
        var historialesClinicos = historialClinicoService.getHistorialClinico();
        model.addAttribute("historialesClinicos", historialesClinicos);
        return "/historialClinico/index";
    }
    
    @GetMapping("/historialClinico/nuevo")
    public String nuevoHistorialClinico (HistorialClinico historialClinico){
        return "/historialClinico/modificar";
    }
    @PostMapping("/historialClinico/guardar")
    public String guardarHistorialClinico(HistorialClinico historialClinico){
        historialClinicoService.save(historialClinico);
        return "redirect:/historialClinico/index";
    }
    
    @GetMapping("/historialClinico/modificar/{idHistorialClinico}")
    public String modificarHistorialClinico(HistorialClinico historialClinico, Model model){
        historialClinico = historialClinicoService.getHistorialClinico(historialClinico);
        model.addAttribute("historialClinico", historialClinico);
        return "/historialClinico/modificar";
    }
    @GetMapping("/historialClinico/eliminar/{idHistorialClinico}")
    public String eliminarHistorialClinico(HistorialClinico historialClinico){
        historialClinicoService.delete(historialClinico);
        return "redirect:/historialClinico/index";
    }
    @GetMapping("/historialClinico/busquedaEspecie")
    public String busquedaEspecie(HistorialClinico historialClinico, Model model) {
        model.addAttribute("historialClinico", historialClinico);
        return "/historialClinico/busquedaEspecie";
    }

    @PostMapping("/historialClinico/buscarEspecie")
    public String buscarEspecie(HistorialClinico historialClinico, Model model) {

        var historiales = historialClinicoService.getHistorialPorEspecie(historialClinico.getNombreEspecie());
        model.addAttribute("historialesClinicos", historiales);
        model.addAttribute("historialClinico", historialClinico);
        return "/historialClinico/busquedaEspecie";
    }
}
