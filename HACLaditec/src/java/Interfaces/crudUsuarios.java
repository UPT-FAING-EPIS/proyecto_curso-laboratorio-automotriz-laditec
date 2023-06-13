/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import java.util.List;
import Modelo.Usuario;


public interface crudUsuarios {
    public List listar();
    public Usuario list(int idusuario);
    public boolean add(Usuario usu);
    public boolean edit(Usuario usu);
}
