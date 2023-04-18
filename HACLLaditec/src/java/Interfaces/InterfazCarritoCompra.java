/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.*;
    
/**
 *
 * @author 
 */
public interface InterfazCarritoCompra {
  
    public BoletaVenta CrearBoleta(double valor,PedidoVenta ped);
    public boolean InsertarDetalleBoleta(DetalleBolVenta dbv);
   
   
}
