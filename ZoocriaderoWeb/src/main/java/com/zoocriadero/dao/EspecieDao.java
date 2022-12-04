/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zoocriadero.dao;

import com.zoocriadero.domain.Especie;
import com.zoocriadero.domain.Rol;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Yohan Alvarado
 */
public interface EspecieDao extends CrudRepository<Especie,Long> {
    
}
