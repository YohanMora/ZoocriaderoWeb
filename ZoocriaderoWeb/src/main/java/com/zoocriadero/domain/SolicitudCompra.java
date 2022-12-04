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
@Table(name="solicitud_compra")
public class SolicitudCompra implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;
    
    String nombre;
    String telefono;
    String cedula;
    String correo;
    Date fecha;
    
    @JoinColumn(name="id_especie", referencedColumnName = "id_especie")
    @ManyToOne
    private Especie especie;

    public SolicitudCompra() {
    }

    public SolicitudCompra(String nombre, String telefono, String cedula, String correo, Date fecha, Especie especie) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
        this.fecha = fecha;
        this.especie = especie;
    }

    
    
    
}
