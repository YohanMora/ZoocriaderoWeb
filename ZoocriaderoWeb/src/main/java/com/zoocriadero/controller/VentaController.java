
package com.zoocriadero.controller;

import com.zoocriadero.domain.Venta;
import com.zoocriadero.service.VentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class VentaController {
    @Autowired
    private VentaService ventaService;
    @GetMapping("/venta/listado")
    public String inicio(Model model){
        var ventas = ventaService.getVenta();
        model.addAttribute("ventas", ventas);
        return "/venta/listado";
    }
    
    @GetMapping("/venta/nueva")
    public String nuevaVenta (Venta venta){
        return "/venta/modifica";
    }
    @PostMapping("/venta/guardar")
    public String guardarVenta(Venta venta){
        ventaService.save(venta);
        return "redirect:/venta/listado";
    }
    
    @GetMapping("/venta/modificar/{idVenta}")
    public String modificarVenta(Venta venta, Model model){
        venta = ventaService.getVenta(venta);
        model.addAttribute("venta", venta);
        return "/venta/modifica";
    }
    @GetMapping("/venta/eliminar/{idVenta}")
    public String modificarVenta(Venta venta){
        ventaService.delete(venta);
        return "redirect:/venta/listado";
    }
}
