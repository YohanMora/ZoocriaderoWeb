
package com.zoocriadero.service;

import com.zoocriadero.dao.VentaDao;
import com.zoocriadero.domain.Venta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
    private VentaDao ventaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Venta> getVenta() {
        var lista = (List<Venta>) ventaDao.findAll();
        return lista;
    }

    @Override
    @Transactional
    public void save(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    @Transactional
    public void delete(Venta venta) {
        ventaDao.delete(venta);
    }

    @Override
    @Transactional(readOnly=true)
    public Venta getVenta(Venta venta) {
        return ventaDao.findById(venta.getIdVenta()).orElse(null);
        //return null;
    }
    
}
