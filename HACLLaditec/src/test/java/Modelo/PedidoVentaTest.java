package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoVentaTest {

    public PedidoVentaTest() {
    }

        @Test
    public void testGetSetIdPedido() {
        PedidoVenta pedido = new PedidoVenta();
        pedido.setIdpedido(1);
        assertEquals(1, pedido.getIdpedido());
    }

    @Test
    public void testGetSetIdUsuario() {
        PedidoVenta pedido = new PedidoVenta();
        pedido.setIdusuario(2);
        assertEquals(2, pedido.getIdusuario());
    }

    @Test
    public void testGetSetFecha() {
        PedidoVenta pedido = new PedidoVenta();
        pedido.setFecha("2023-06-10");
        assertEquals("2023-06-10", pedido.getFecha());
    }

    @Test
    public void testGetSetEstado() {
        PedidoVenta pedido = new PedidoVenta();
        pedido.setEstado("En proceso");
        assertEquals("En proceso", pedido.getEstado());
    }

    @Test
    public void testGetSetHash() {
        PedidoVenta pedido = new PedidoVenta();
        pedido.setHash("abc123");
        assertEquals("abc123", pedido.getHash());
    }

    @Test
    public void testGetSetLacchainid() {
        PedidoVenta pedido = new PedidoVenta();
        pedido.setLacchainid("xyz789");
        assertEquals("xyz789", pedido.getLacchainid());
    }

    @Test
    public void testGetSetTxrid() {
        PedidoVenta pedido = new PedidoVenta();
        pedido.setTxrid("123456");
        assertEquals("123456", pedido.getTxrid());
    }

}
