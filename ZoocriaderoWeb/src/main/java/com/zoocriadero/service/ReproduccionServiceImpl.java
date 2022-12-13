/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.dao.ReproduccionDao;
import com.zoocriadero.domain.Reproduccion;
import com.zoocriadero.domain.SolicitudCompra;
import java.util.List;
import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yohan Alvarado
 */
@Service
public class ReproduccionServiceImpl implements ReproduccionService {
    
    @Autowired
    private ReproduccionDao reproduccionDao;

    @Override
    public List<Reproduccion> getReproducciones() {
        return  reproduccionDao.findAllByOrderByFechaDesc();
    }

    @Override
    public void save(Reproduccion reproduccion) {
        reproduccionDao.save(reproduccion);
    }

    @Override
    public Reproduccion getReproduccion(Reproduccion reproduccion) {
        return reproduccionDao.findById(reproduccion.getIdReproduccion()).orElse(null);
    }

    @Override
    public void delete(Reproduccion reproduccion) {
        reproduccionDao.delete(reproduccion);
    }
   
    
}
