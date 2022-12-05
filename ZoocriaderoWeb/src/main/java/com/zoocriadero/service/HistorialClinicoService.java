
package com.zoocriadero.service;

import com.zoocriadero.domain.HistorialClinico;
import java.util.List;


public interface HistorialClinicoService {
    
    public List<HistorialClinico> getHistorialClinico();
    
    public void save (HistorialClinico historialClinico);
    
    public void delete (HistorialClinico historialClinico);
    
    public HistorialClinico getHistorialClinico (HistorialClinico historialClinico);
    
    public List<HistorialClinico> getHistorialPorEspecie(String nombreEspecie);
    
}
