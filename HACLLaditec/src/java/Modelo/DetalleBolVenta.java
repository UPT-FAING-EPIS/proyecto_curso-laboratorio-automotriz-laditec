/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



public class DetalleBolVenta {

    private int iddetalleboleta;
    private String fkserieboleta;
    private int fknroboleta;
    private int fkidrepuesto;
    private int cantidad;
    private double importe;
    
    public DetalleBolVenta(int iddetalleboleta, String fkserieboleta, int fknroboleta, int fkidrepuesto, int cantidad, double importe) {
        this.iddetalleboleta = iddetalleboleta;
        this.fkserieboleta = fkserieboleta;
        this.fknroboleta = fknroboleta;
        this.fkidrepuesto = fkidrepuesto;
        this.cantidad = cantidad;
        this.importe = importe;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
    public int getIddetalleboleta() {
        return iddetalleboleta;
    }

    public void setIddetalleboleta(int iddetalleboleta) {
        this.iddetalleboleta = iddetalleboleta;
    }

    public String getFkserieboleta() {
        return fkserieboleta;
    }

    public void setFkserieboleta(String fkserieboleta) {
        this.fkserieboleta = fkserieboleta;
    }

    public int getFknroboleta() {
        return fknroboleta;
    }

    public void setFknroboleta(int fknroboleta) {
        this.fknroboleta = fknroboleta;
    }

    
    
    public int getFkidrepuesto() {
        return fkidrepuesto;
    }

    public void setFkidrepuesto(int fkidrepuesto) {
        this.fkidrepuesto = fkidrepuesto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
    public DetalleBolVenta() {
    }
    
}
