/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.domain;

import java.io.Serializable;
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
@Table(name="usuario")

public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario; //Hibernate lo convierte en idCliente
    
    String nombre;
    String apellidos;
    String correo;
    String contrasenna;

    @JoinColumn(name="id_rol", referencedColumnName = "id_rol")
    @ManyToOne
    private Rol rol;
    
    public Usuario(){
    
    }

    public Usuario(String nombre, String apellidos, String correo, String contrasenna, Rol rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasenna = contrasenna;
        this.rol = rol;
    }
    
    
    
}
