/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Comentarios {
    private int idcomentario;
    private int fkidusuario;
    private String nombre;
    private String descripcion;
    private int calificacion;
    
    public int getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public int getFkidusuario() {
        return fkidusuario;
    }

    public void setFkidusuario(int fkidusuario) {
        this.fkidusuario = fkidusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Comentarios(int idcomentario, int fkidusuario, String nombre, String descripcion, int calificacion) {
        this.idcomentario = idcomentario;
        this.fkidusuario = fkidusuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.calificacion = calificacion;
    }

    public Comentarios() {
    }



    

}
