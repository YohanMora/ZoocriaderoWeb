
package com.zoocriadero.controller;

import com.zoocriadero.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @GetMapping("/catalogo/index")
    public String inicio(Model model){
        var productos=productoService.getProductos();
        model.addAttribute("productos", productos);
        return "/catalogo/index";
    }
    
}
