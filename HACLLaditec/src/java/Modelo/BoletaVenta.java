/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Helbert Andres Condori Loayza
 */
public class BoletaVenta {
    private int nroboleta;
    private String serieboleta;
    private int fkidpedido;
    private String fechaemision;
    private Double  total;
    private Double impuesto;

    public int getNroboleta() {
        return nroboleta;
    }

    public void setNroboleta(int nroboleta) {
        this.nroboleta = nroboleta;
    }

    public String getSerieboleta() {
        return serieboleta;
    }

    public void setSerieboleta(String serieboleta) {
        this.serieboleta = serieboleta;
    }

    public int getFkidpedido() {
        return fkidpedido;
    }

    public void setFkidpedido(int fkidpedido) {
        this.fkidpedido = fkidpedido;
    }

    public String getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(String fechaemision) {
        this.fechaemision = fechaemision;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public BoletaVenta(int nroboleta, String serieboleta, int fkidpedido, String fechaemision, Double total, Double impuesto) {
        this.nroboleta = nroboleta;
        this.serieboleta = serieboleta;
        this.fkidpedido = fkidpedido;
        this.fechaemision = fechaemision;
        this.total = total;
        this.impuesto = impuesto;
    }

    public BoletaVenta() {
    }

}
