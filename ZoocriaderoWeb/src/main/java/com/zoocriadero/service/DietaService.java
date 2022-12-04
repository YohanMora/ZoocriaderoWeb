/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.domain.Dieta;
import java.util.List;

/**
 *
 * @author Yohan Alvarado
 */
public interface DietaService {
    
    public void save(Dieta dieta);
    
    public void delete(Dieta dieta);
    
    public Dieta getDieta(Dieta dieta);
    
    public List<Dieta> getDietas(Long idEspecie);
}
