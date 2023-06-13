/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Repuesto {
    private int idrepuesto;
    private int fkidalmacen;
    private int fkidestado;
    private String nombre;
    private int fkidcategoria;
    private String imagen;
    private Double preciounitario;
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

    public int getIdrepuesto() {
        return idrepuesto;
    }

    public void setIdrepuesto(int idrepuesto) {
        this.idrepuesto = idrepuesto;
    }

    public int getFkidalmacen() {
        return fkidalmacen;
    }

    public void setFkidalmacen(int fkidalmacen) {
        this.fkidalmacen = fkidalmacen;
    }

    public int getFkidestado() {
        return fkidestado;
    }

    public void setFkidestado(int fkidestado) {
        this.fkidestado = fkidestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFkidcategoria() {
        return fkidcategoria;
    }

    public void setFkidcategoria(int fkidcategoria) {
        this.fkidcategoria = fkidcategoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public Repuesto(int idrepuesto, int fkidalmacen, int fkidestado, String nombre, int fkidcategoria, String imagen, Double preciounitario, int cantidad) {
        this.idrepuesto = idrepuesto;
        this.fkidalmacen = fkidalmacen;
        this.fkidestado = fkidestado;
        this.nombre = nombre;
        this.fkidcategoria = fkidcategoria;
        this.imagen = imagen;
        this.preciounitario = preciounitario;
        this.cantidad = cantidad;
    }

    

    public Repuesto() {
    }
    
    
}
