/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template

 */
package Interfaces;
import Modelo.*;
import java.util.*;

public interface InterfazProducto {
    public List listar(String filtro);
    public Producto listarPorId(int identificador);
}
