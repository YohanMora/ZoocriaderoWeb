
package com.zoocriadero.service;

import com.zoocriadero.dao.ReporteDao;
import com.zoocriadero.domain.Reportes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReporteServiceImpl implements ReporteService{
    @Autowired
    private ReporteDao reporteDao;
    @Override
    @Transactional(readOnly=true)
    public List<Reportes> getReporte() {
        var reportes = (List<Reportes>) reporteDao.findAll();
        return reportes;
    }

    @Override
    @Transactional
    public void save(Reportes reporte) {
        reporteDao.save(reporte);
    }

    @Override
    @Transactional
    public void delete(Reportes reporte) {
        reporteDao.delete(reporte);
    }

    @Override
    @Transactional(readOnly=true)
    public Reportes getReportes(Reportes reporte) {
        return reporteDao.findById(reporte.getIdReporte()).orElse(null);
    }
    
}
