/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.service;

import com.zoocriadero.dao.SolicitudCompraDao;
import com.zoocriadero.domain.SolicitudCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yohan Alvarado
 */
@Service
public class SolicitudCompraServiceImpl implements SolicitudCompraService {
    
    @Autowired
    private SolicitudCompraDao solicitudCompraDao;
    
    @Override
    public void save(SolicitudCompra solicitud) {
        solicitudCompraDao.save(solicitud);
    }
    
}
