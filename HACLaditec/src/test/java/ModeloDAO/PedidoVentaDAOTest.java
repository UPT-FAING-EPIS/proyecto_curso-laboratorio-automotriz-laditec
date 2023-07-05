/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModeloDAO;

import Modelo.PedidoVenta;

import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 *
 * @author Andre
 */
public class PedidoVentaDAOTest {

    @Mock
    private PedidoVentaDAO pedidoVentaDAO;

    public PedidoVentaDAOTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    
    @Test
    public void testListar() {
        List<PedidoVenta> listaMock = new ArrayList<>();
        PedidoVenta pedidoMock = new PedidoVenta();
        pedidoMock.setIdpedido(1);
        pedidoMock.setIdusuario(1);
        pedidoMock.setFecha("2023-07-04");
        pedidoMock.setEstado("En proceso");
        pedidoMock.setTxrid("txrid");
        pedidoMock.setLacchainid("lacchainid");
        pedidoMock.setHash("hash");
        listaMock.add(pedidoMock);
        when(pedidoVentaDAO.listar()).thenReturn(listaMock);

        List<PedidoVenta> resultado = pedidoVentaDAO.listar();

        verify(pedidoVentaDAO, times(1)).listar();
        assertEquals(listaMock, resultado);
    }
    
    @Test
    public void testList() {
        PedidoVenta pedidoMock = new PedidoVenta();
        pedidoMock.setIdpedido(1);
        pedidoMock.setIdusuario(1);
        pedidoMock.setFecha("2023-07-04");
        pedidoMock.setEstado("En proceso");
        pedidoMock.setTxrid("txrid");
        pedidoMock.setLacchainid("lacchainid");
        pedidoMock.setHash("hash");
        when(pedidoVentaDAO.list(1)).thenReturn(pedidoMock);

        PedidoVenta resultado = pedidoVentaDAO.list(1);

        verify(pedidoVentaDAO, times(1)).list(1);
        assertEquals(pedidoMock, resultado);
    }

    @Test
    public void testAdd() {
        when(pedidoVentaDAO.add(any(PedidoVenta.class))).thenReturn(true);

        boolean resultado = pedidoVentaDAO.add(new PedidoVenta());

        verify(pedidoVentaDAO, times(1)).add(any(PedidoVenta.class));
        assertEquals(true, resultado);
    }

    @Test
    public void testEditar() {
        when(pedidoVentaDAO.edit(any(PedidoVenta.class))).thenReturn(true);

        boolean resultado = pedidoVentaDAO.edit(new PedidoVenta());

        verify(pedidoVentaDAO, times(1)).edit(any(PedidoVenta.class));
        assertEquals(true, resultado);
    }

    @Test
    public void testMtdAsignarHash() {
        when(pedidoVentaDAO.mtdAsignarHash(any(PedidoVenta.class))).thenReturn(true);

        boolean resultado = pedidoVentaDAO.mtdAsignarHash(new PedidoVenta());

        verify(pedidoVentaDAO, times(1)).mtdAsignarHash(any(PedidoVenta.class));
        assertEquals(true, resultado);
    }
    
    
    
  

}
