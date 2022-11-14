
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
@Table(name="investigacion")
public class Investigacion implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_investigacion")
    private Long idInvestigacion;
    private String investigador;
    private String fechaInvestigacion;
    private String especieInvestigacion;
    private String descripcionInvestigacion;

    public Investigacion() {
    }

    public Investigacion(String investigador, String fechaInvestigacion, String especieInvestigacion, String descripcionInvestigacion) {
        this.investigador = investigador;
        this.fechaInvestigacion = fechaInvestigacion;
        this.especieInvestigacion = especieInvestigacion;
        this.descripcionInvestigacion = descripcionInvestigacion;
    }
    
}
