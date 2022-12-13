/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.domain.Reproduccion;
import java.util.List;

/**
 *
 * @author Yohan Alvarado
 */
public interface ReproduccionService {
    
    public List<Reproduccion> getReproducciones();
    
    public void save(Reproduccion reproduccion);
    
    public Reproduccion getReproduccion(Reproduccion reproduccion);
    
    public void delete (Reproduccion reproduccion);
}
