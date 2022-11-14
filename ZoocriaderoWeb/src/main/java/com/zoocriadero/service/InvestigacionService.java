
package com.zoocriadero.service;

import com.zoocriadero.domain.Investigacion;
import java.util.List;


public interface InvestigacionService {
    public List<Investigacion> getInvestigacion();
    
    public void save (Investigacion investigacion);
    
    public void delete (Investigacion investigacion);
    
    public Investigacion getInvestigacion (Investigacion investigacion);
}

