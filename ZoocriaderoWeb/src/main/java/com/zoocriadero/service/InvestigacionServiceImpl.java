
package com.zoocriadero.service;

import com.zoocriadero.dao.InvestigacionDao;
import com.zoocriadero.domain.Investigacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvestigacionServiceImpl implements InvestigacionService{
    @Autowired
    private InvestigacionDao investigacionDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Investigacion> getInvestigacion() {
        var lista = (List<Investigacion>) investigacionDao.findAll();
        return lista;
    }

    @Override
    public void save(Investigacion investigacion) {
        investigacionDao.save(investigacion);
    }

    @Override
    public void delete(Investigacion investigacion) {
        investigacionDao.delete(investigacion);
    }

    @Override
    public Investigacion getInvestigacion(Investigacion investigacion) {
        return investigacionDao.findById(investigacion.getIdInvestigacion()).orElse(null);
    }
    
}
