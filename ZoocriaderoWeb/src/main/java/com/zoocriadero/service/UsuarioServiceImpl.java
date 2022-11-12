/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.dao.UsuarioDao;
import com.zoocriadero.domain.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yohan Alvarado
 */
@Service
public class UsuarioServiceImpl implements UsuarioService  {

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Usuario> validateUser(String correo, String contrasenna) {
        
        return usuarioDao.findByCorreoAndContrasenna(correo, contrasenna);
        
    }
    
}
