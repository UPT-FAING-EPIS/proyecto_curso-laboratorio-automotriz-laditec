/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModeloDAO;

import Modelo.PedidoVenta;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */

public class PedidoVentaDAOTest {
    
     public PedidoVentaDAOTest() {
    }

    @Test
    public void testListar() {
        PedidoVentaDAO dao = new PedidoVentaDAO();
        List<PedidoVenta> lista = dao.listar();
        assertNotNull(lista);
        assertFalse(lista.isEmpty());
        // Verifica más condiciones sobre la lista obtenida
    }

    @Test
    public void testAdd() {
        PedidoVentaDAO dao = new PedidoVentaDAO();
        PedidoVenta pedido = new PedidoVenta();
        pedido.setIdusuario(1);
        pedido.setFecha("2023-06-06");
        pedido.setEstado("A");
        boolean resultado = dao.add(pedido);
        assertTrue(resultado);
    }

    @Test
    public void testContarPedidos() {
        PedidoVentaDAO dao = new PedidoVentaDAO();
        int cantidad = dao.contarpedidos();
        assertTrue(cantidad >= 0); // Verifica que la cantidad sea no negativa
        // Verifica más condiciones sobre la cantidad de pedidos
    }

    @Test
    public void testEdit() {
        PedidoVentaDAO dao = new PedidoVentaDAO();
        int id = 1;
        PedidoVenta pedido = dao.list(id);
        assertNotNull(pedido);
        pedido.setEstado("A");
        boolean resultado = dao.edit(pedido);
        assertTrue(resultado);
        // Verifica más condiciones después de editar el pedido
    }

    @Test
    public void testMtdAsignarHash() {
        PedidoVentaDAO dao = new PedidoVentaDAO();
        int id = 1; // ID de un pedido existente
        PedidoVenta pedido = dao.list(id);
        assertNotNull(pedido);
        
        pedido.setTxrid("txrid123");
        pedido.setLacchainid("lacchainid123");
        pedido.setHash("hash123");
        boolean resultado = dao.mtdAsignarHash(pedido);
        assertTrue(resultado);
        // Verifica más condiciones después de asignar el hash al pedido
    }
    
}
