/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.zoocriadero.controller;

import com.zoocriadero.domain.SolicitudCompra;
import com.zoocriadero.mail.JavaEmailSender;
import com.zoocriadero.service.EspecieService;
import com.zoocriadero.service.SolicitudCompraService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Yohan Alvarado
 */
@Controller
public class SolicitudCompraController {

    @Autowired
    EspecieService especieService;

    @Autowired
    SolicitudCompraService solicitudCompraService;

    @RequestMapping("/solicitud/solicitud")
    public String page(Model model) {

        var listEspecies = especieService.getEspecies();

        model.addAttribute("listEspecies", listEspecies);

        return "/solicitud/solicitud_compra";
    }

    @PostMapping("/solicitud/enviarSolicitud")
    public String guardarSolicitud(Model model, SolicitudCompra solicitud) {
        
        Date date = new Date();    
        solicitud.setFecha(date);
        
        JavaEmailSender email = new JavaEmailSender();

        var especie = especieService.getEspecie(solicitud.getEspecie());
        
        //Sending email to user
        email.createAndSendEmail(solicitud.getCorreo(), "Solicitud Compra de especie",
                "Estimado(a)" + solicitud.getNombre() + ".\n "
                        + "A continuación se detalla la solictud realiazada a nuestro zoocriadero.\n"
                + "Datos de la solicitud:\n Nombre: " + solicitud.getNombre() + ".\n"
                + "Teléfono: " + solicitud.getTelefono() + ".\n"
                + "Cédula: " + solicitud.getTelefono() + ".\n"
                + "Correo: " + solicitud.getCorreo() + ".\n"
                + "Nombre de la especie: " + especie.getNombre() + ".\n");
        
        //Sending email to admin
        email.createAndSendEmail("zoocriaderoweb@gmail.com", "Solicitud Compra de especie",
                "Has recibido una solicitud de compra de especie por parte de: " + solicitud.getNombre() + ".\n"
                + "Datos de la solicitud:\n Nombre: " + solicitud.getNombre() + ".\n"
                + "Teléfono: " + solicitud.getTelefono() + ".\n"
                + "Cédula: " + solicitud.getTelefono() + ".\n"
                + "Correo: " + solicitud.getCorreo() + ".\n"
                + "Nombre de la especie: " + especie.getNombre() + ".\n");

        solicitudCompraService.save(solicitud);

        return "redirect:/solicitud/solicitud/";
    }
}
