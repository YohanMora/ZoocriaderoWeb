
package com.zoocriadero.dao;

import com.zoocriadero.domain.HistorialClinico;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface HistorialClinicoDao extends CrudRepository<HistorialClinico, Long>{
    List<HistorialClinico> findByNombreEspecie(String nombreEspecie);
}
