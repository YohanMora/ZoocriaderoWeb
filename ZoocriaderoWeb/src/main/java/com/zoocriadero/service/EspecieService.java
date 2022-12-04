/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.domain.Especie;
import java.util.List;

/**
 *
 * @author Yohan Alvarado
 */
public interface EspecieService {
    public List<Especie> getEspecies();
    
    public void insertEspecie(String nombre);
    
    public Especie getEspecie(Especie especie);
   
}
