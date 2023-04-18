/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.Comentarios;
import java.util.List;


public interface crudComentario {
    public List listar();
    public Comentarios list(int idusuario);
    public boolean add(Comentarios com);

}
