
package com.zoocriadero.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="historial_clinico")
public class HistorialClinico implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_historial_clinico")
    private Long idHistorialClinico;
    
    String nombreEspecie;
    String caracteristicasFisicas;
    String tipoEspecie;
    String sexo;
    String fecha;
    String tratamiento;    

    public HistorialClinico() {
    }

    public HistorialClinico(String nombreEspecie, String caracteristicasFisicas, String tipoEspecie, String sexo, String fecha, String tratamiento){ 
        this.nombreEspecie = nombreEspecie;
        this.caracteristicasFisicas = caracteristicasFisicas;
        this.tipoEspecie = tipoEspecie;
        this.sexo = sexo;
        this.fecha = fecha;
        this.tratamiento = tratamiento;
    }
    
    
   
    
}
