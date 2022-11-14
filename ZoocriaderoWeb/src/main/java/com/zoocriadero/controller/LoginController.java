/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.zoocriadero.controller;

import com.zoocriadero.domain.Usuario;
import com.zoocriadero.mail.JavaEmailSender;
import com.zoocriadero.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Yohan Alvarado
 */
@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login/login")
    public String page(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "/login/login";
    }

    @PostMapping("/login/validateUser")
    public String validateUser(Usuario usuario, Model model) {

        var getUser = usuarioService.validateUser(usuario.getCorreo(), usuario.getContrasenna());

        boolean validateUser = getUser.isEmpty();

        if (validateUser == true) {
            return "/login/login";
        }

        return "/login/changePassword";
    }

    @GetMapping("/login/changePassword")
    public String changePassword(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);
        return "/login/changePassword";
    }

    @PostMapping("/login/sendMail")
    public String sendMail(Usuario usuario, Model model) {

        JavaEmailSender email = new JavaEmailSender();
        //Sending email
        email.createAndSendEmail(usuario.getCorreo(), "Solicitud Cambio de Contraeña",
                "Yo "+usuario.getCorreo()+", deseo que se me actualice mi contraseña.");

        return "/login/changePassword";
    }
}
