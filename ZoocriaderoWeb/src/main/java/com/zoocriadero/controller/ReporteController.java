package com.zoocriadero.controller;

import com.zoocriadero.domain.Reportes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.zoocriadero.service.ReporteService;

@Controller

public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/reporte/listado")
    public String inicio(Model model) {
        var reportes = reporteService.getReporte();
        model.addAttribute("reportes", reportes);
        return "/reporte/listado";
    }

    @GetMapping("/reporte/nuevo")
    public String nuevoReporte (Reportes reporte) {
        return "/reporte/modifica";
    }

    @PostMapping("/reporte/guardar")
    public String guardarReporte(Reportes reportes) {
        reporteService.save(reportes);
        return "redirect:/reporte/listado";
    }
    @GetMapping("/reporte/modifica/{idReporte}")
    public String modificarReporte(Reportes reporte, Model model){
        reporte = reporteService.getReportes(reporte);
        model.addAttribute("reporte", reporte);
        return "/reporte/modifica";
    }
    @GetMapping("/reporte/eliminar/{idReporte}")
    public String eliminarReporte(Reportes reporte){
        reporteService.delete(reporte);
        return "redirect:/reporte/listado";
    }
}
