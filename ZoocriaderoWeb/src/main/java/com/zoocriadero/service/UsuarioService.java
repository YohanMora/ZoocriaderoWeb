/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.domain.Usuario;
import java.util.List;

/**
 *
 * @author Yohan Alvarado
 */
public interface UsuarioService {
    
    public List<Usuario> validateUser(String correo, String contrasenna); 
}
