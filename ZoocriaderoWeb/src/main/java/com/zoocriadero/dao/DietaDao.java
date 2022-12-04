/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zoocriadero.dao;

import com.zoocriadero.domain.Dieta;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Yohan Alvarado
 */
public interface DietaDao extends CrudRepository<Dieta,Long>{
    public List<Dieta> findByEspecieIdEspecie(Long idEspecie);
   
}
