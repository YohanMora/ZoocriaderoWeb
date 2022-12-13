
package com.zoocriadero.dao;

import com.zoocriadero.domain.Producto;
import org.springframework.data.repository.CrudRepository;


public interface ProductoDao extends CrudRepository<Producto, Long>{
    
}
