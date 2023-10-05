package com.example.demo.hexadecimal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="facturas_items")
public class ItemsFactura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producto_id")
    private Productos producto;

    private Productos getProducto() {return  producto;}

    public void setProducto(Productos producto) {this.producto = producto;}

    private Integer cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte( ) {
        return cantidad.doubleValue() * producto.getPrecio();
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
}
