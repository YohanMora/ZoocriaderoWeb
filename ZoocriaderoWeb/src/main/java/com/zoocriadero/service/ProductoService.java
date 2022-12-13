
package com.zoocriadero.service;

import com.zoocriadero.domain.Producto;
import java.util.List;


public interface ProductoService {
    public List<Producto> getProductos();
    
    public void save (Producto producto);
    
    public void delete (Producto producto);
    
    public Producto getProducto (Producto producto);
}
