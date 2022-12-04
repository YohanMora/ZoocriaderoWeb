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
@Table(name="dieta")
public class Dieta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDieta;
    
    String alimento;
    int peso;
    int calorias;
    int cantidad;
    String fecha;
    
    @JoinColumn(name="id_especie", referencedColumnName = "id_especie")
    @ManyToOne
    private Especie especie;
    
    public Dieta(){
    }

    public Dieta(String alimento, int peso, int calorias, int cantidad, String fecha, Especie especie) {
        this.alimento = alimento;
        this.peso = peso;
        this.calorias = calorias;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.especie = especie;
    }
    
    
}
