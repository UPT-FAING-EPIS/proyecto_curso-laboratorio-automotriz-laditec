/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Modelo.DetalleBolVenta;
import java.util.List;

public interface crudDetalleBolVenta {
    public List listar();
    public DetalleBolVenta list(int id);
    public boolean add(DetalleBolVenta dbv);
    public boolean edit(DetalleBolVenta dbv);
    public List listarby(int id,String as);
    public boolean addcarrito(DetalleBolVenta dbv);

}
