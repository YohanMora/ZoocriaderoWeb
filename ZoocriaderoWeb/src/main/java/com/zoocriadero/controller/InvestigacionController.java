
package com.zoocriadero.controller;

import com.zoocriadero.domain.Investigacion;
import com.zoocriadero.service.EspecieService;
import com.zoocriadero.service.InvestigacionService;
import com.zoocriadero.service.InvestigacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class InvestigacionController {
    @Autowired
    private InvestigacionService investigacionService;
    @Autowired
    private EspecieService especieService;
    
    @GetMapping("/investigacion/listado")
    public String inicio(Model model){
        var investigaciones = investigacionService.getInvestigacion();
        model.addAttribute("investigaciones", investigaciones);
        return "/investigacion/listado";
    }
    
    @GetMapping("/investigacion/nueva")
    public String nuevaInvestigacion (Investigacion investigacion){
        return "/investigacion/modifica";
    }
    @PostMapping("/investigacion/guardar")
    public String guardarInvestigacion(Investigacion investigacion){
        investigacionService.save(investigacion);
        especieService.insertEspecie(investigacion.getEspecieInvestigacion());
        return "redirect:/investigacion/listado";
    }
    
    @GetMapping("/investigacion/modificar/{idInvestigacion}")
    public String modificarInvestigacion(Investigacion investigacion, Model model){
        investigacion = investigacionService.getInvestigacion(investigacion);
        model.addAttribute("investigacion", investigacion);
        return "/investigacion/modifica";
    }
    @GetMapping("/investigacion/eliminar/{idInvestigacion}")
    public String modificarInvestigacion(Investigacion investigacion){
        investigacionService.delete(investigacion);
        return "redirect:/investigacion/listado";
    }
    
}
