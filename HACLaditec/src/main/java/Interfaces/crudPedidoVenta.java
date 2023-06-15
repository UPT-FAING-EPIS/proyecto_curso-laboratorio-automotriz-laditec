/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.PedidoVenta;
import java.util.List;

public interface crudPedidoVenta {
    public List listar();
    public PedidoVenta list(int id);
    public boolean add(PedidoVenta ped);
    public boolean edit(PedidoVenta ped);

}
