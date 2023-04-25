package Interfaces;
import Modelo.PedidoVenta;
import java.util.List;
public interface crudPedidoVenta {
    public List listar();
    public PedidoVenta list(int id);
    public boolean add(PedidoVenta ped);
    public boolean edit(PedidoVenta ped);

}
