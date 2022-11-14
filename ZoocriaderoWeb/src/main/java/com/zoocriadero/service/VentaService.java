
package com.zoocriadero.service;

import com.zoocriadero.domain.Venta;
import java.util.List;


public interface VentaService {
    public List<Venta> getVenta();
    
    public void save (Venta venta);
    
    public void delete (Venta venta);
    
    public Venta getVenta (Venta venta);
}
