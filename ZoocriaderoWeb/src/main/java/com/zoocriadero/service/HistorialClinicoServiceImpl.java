
package com.zoocriadero.service;

import com.zoocriadero.dao.HistorialClinicoDao;
import com.zoocriadero.domain.HistorialClinico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistorialClinicoServiceImpl implements HistorialClinicoService{
    @Autowired
    private HistorialClinicoDao historialClinicoDao;
    @Override
    @Transactional(readOnly=true)
    public List<HistorialClinico> getHistorialClinico() {
        var historialClinico = (List<HistorialClinico>) historialClinicoDao.findAll();
        return historialClinico;
    }

    @Override
    @Transactional
    public void save(HistorialClinico historialClinico) {
        historialClinicoDao.save(historialClinico);
    }

    @Override
    @Transactional
    public void delete(HistorialClinico historialClinico) {
        historialClinicoDao.delete(historialClinico);
    }

    @Override
    @Transactional(readOnly=true)
    public HistorialClinico getHistorialClinico(HistorialClinico historialClinico) {
        return historialClinicoDao.findById(historialClinico.getIdHistorialClinico()).orElse(null);
    }
    @Override
    public List<HistorialClinico> getHistorialPorEspecie(String nombreEspecie) {
        return historialClinicoDao.findByNombreEspecie(nombreEspecie);

    }
    
}
