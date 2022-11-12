/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zoocriadero.dao;

import com.zoocriadero.domain.Rol;
import com.zoocriadero.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Yohan Alvarado
 */
public interface RolDao extends CrudRepository<Rol,Long> {
    
}
