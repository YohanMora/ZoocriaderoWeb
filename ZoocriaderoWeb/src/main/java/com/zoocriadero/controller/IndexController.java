/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.zoocriadero.controller;

import com.zoocriadero.domain.Usuario;
import com.zoocriadero.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yohan Alvarado
 */
@Controller
public class IndexController {
    
    @Autowired
    private ProductoService productoService;
    
    @RequestMapping("/")
    public String page(Model model) {
        
        var productos=productoService.getProductos();
        model.addAttribute("productos", productos);
        
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "/login/login";
    }
    
    @RequestMapping("/menu")
    public String menu(Model model, Usuario usuario) {
        //model.addAttribute("usuario", usuario);
        return "/menu";
    }
    
    
}
