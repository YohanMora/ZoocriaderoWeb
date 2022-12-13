
package com.zoocriadero.service;

import com.zoocriadero.domain.Reportes;
import java.util.List;


public interface ReporteService {
    public List<Reportes> getReporte();
    
    public void save (Reportes reporte);
    
    public void delete (Reportes reporte);
    
    public Reportes getReportes(Reportes reporte);
}
