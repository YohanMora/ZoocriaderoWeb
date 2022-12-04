/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.dao.EspecieDao;
import com.zoocriadero.domain.Especie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yohan Alvarado
 */
@Service
public class EspecieServiceImpl implements EspecieService {

    @Autowired
    private EspecieDao especieDao;
    @Override
    public List<Especie> getEspecies() {
        return (List<Especie>)especieDao.findAll();
    }

    @Override
    public void insertEspecie(String nombre) {
        Especie especie = new Especie();
        
        especie.setNombre(nombre);
        
        especieDao.save(especie);
    }

    @Override
    public Especie getEspecie(Especie especie) {
        return especieDao.findById(especie.getIdEspecie()).orElse(null);
    }
    
}
