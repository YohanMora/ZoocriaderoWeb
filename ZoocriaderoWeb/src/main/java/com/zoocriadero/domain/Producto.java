
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
@Table(name="catalogo")
public class Producto implements Serializable{
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_producto")
    private Long idProducto;
    private String descripcion;
    private Double precio;
    private int existencias;
    @Column(name="ruta_imagen")
    private String rutaImagen;

    public Producto() {
    }

    public Producto(String descripcion, Double precio, int existencias, String rutaImagen) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
    }
    
    
}
