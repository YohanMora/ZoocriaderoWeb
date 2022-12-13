
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
@Table(name="reportes")
public class Reportes implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_reporte")
    private Long idReporte;
    private String fechaInicio;
    private String fechaFinal;
    private String tipoReporte;

    public Reportes() {
    }

    public Reportes(String fechaInicio, String fechaFinal, String tipoReporte) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.tipoReporte = tipoReporte;
    }
    
    
}
