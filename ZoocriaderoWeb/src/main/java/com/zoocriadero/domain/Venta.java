
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
@Table(name="venta")
public class Venta implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_venta")
    private Long idVenta;
    private String descripcion;
    private String fechaVenta;
    private Double total;
    private String tipoPago;

    public Venta() {
    }

    public Venta(String descripcion, String fechaVenta, Double total, String tipoPago) {
        this.descripcion = descripcion;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.tipoPago = tipoPago;
    }
    
    
}
