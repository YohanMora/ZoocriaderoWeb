/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.dao.DietaDao;
import com.zoocriadero.domain.Dieta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yohan Alvarado
 */
@Service
public class DietaServiceImpl implements DietaService {
    
    @Autowired
    private DietaDao dietaDao;
    
    @Override
    public void save(Dieta dieta) {
        dietaDao.save(dieta);
    }

    @Override
    public void delete(Dieta dieta) {
        dietaDao.delete(dieta);
    }

    @Override
    public Dieta getDieta(Dieta dieta) {
        return dietaDao.findById(dieta.getIdDieta()).orElse(null);
    }

    @Override
    public List<Dieta> getDietas(Long idEspecie) {
        return dietaDao.findByEspecieIdEspecie(idEspecie);
    }
    
}
