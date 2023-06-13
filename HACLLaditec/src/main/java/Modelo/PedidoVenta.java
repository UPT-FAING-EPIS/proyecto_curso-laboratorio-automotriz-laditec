/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class PedidoVenta {
    
    private int idpedido;
    private int idusuario;
    private String fecha;
    private String estado;
    private String hash;
    private String lacchainid;
    private String txrid;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLacchainid() {
        return lacchainid;
    }

    public void setLacchainid(String lacchainid) {
        this.lacchainid = lacchainid;
    }

    public String getTxrid() {
        return txrid;
    }

    public void setTxrid(String txrid) {
        this.txrid = txrid;
    }
    
    

    
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PedidoVenta(int idpedido, int idusuario, String fecha, String estado, String hash, String lacchainid, String txrid) {
        this.idpedido = idpedido;
        this.idusuario = idusuario;
        this.fecha = fecha;
        this.estado = estado;
        this.hash = hash;
        this.lacchainid = lacchainid;
        this.txrid = txrid;
    }

    
    
    public PedidoVenta() {
    }
    
    
    
    
}
