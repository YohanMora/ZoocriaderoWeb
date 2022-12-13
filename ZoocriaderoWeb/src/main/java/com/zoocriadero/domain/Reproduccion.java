/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Yohan Alvarado
 */
@Data
@Entity
@Table(name="reproduccion")
public class Reproduccion implements Serializable {
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReproduccion;
    
    String descripcion;
    String fecha;
    
    @JoinColumn(name="id_especie", referencedColumnName = "id_especie")
    @ManyToOne
    private Especie especie;

    public Reproduccion() {
    }

    public Reproduccion(String descripcion, String fecha, Especie especie) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.especie = especie;
    }
    
    
    
}
