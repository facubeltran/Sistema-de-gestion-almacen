package ar.org.centro8.curso.java.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ar.org.centro8.curso.java.enums.Rubro;


@Entity
@Table(name="articulos")
public class Articulo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true , nullable = false)
    private Integer id;
    private String descripcion;
    @Enumerated(value = EnumType.STRING)
    private Rubro rubro;
    private Double costo;
    private Double precio;
    private Integer stock;
    private Integer stock_minimo;
    private Integer stock_maximo;
    
    public Articulo() {
    }

    public Articulo(String descripcion, Rubro rubro, Double costo, Double precio, Integer stock, Integer stock_minimo,
            Integer stock_maximo) {
        this.descripcion = descripcion;
        this.rubro = rubro;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stock_minimo = stock_minimo;
        this.stock_maximo = stock_maximo;
    }

    public Articulo(Integer id, String descripcion, Rubro rubro, Double costo, Double precio, Integer stock,
            Integer stock_minimo, Integer stock_maximo) {
        this.id = id;
        this.descripcion = descripcion;
        this.rubro = rubro;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stock_minimo = stock_minimo;
        this.stock_maximo = stock_maximo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(Integer stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public Integer getStock_maximo() {
        return stock_maximo;
    }

    public void setStock_maximo(Integer stock_maximo) {
        this.stock_maximo = stock_maximo;
    }

    
}


