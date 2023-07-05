/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModeloDAO;

import Modelo.Repuesto;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 *
 * @author
 */
public class RepuestoDAOTest {

    @Mock
    private RepuestoDAO repuestoDAO;

    public RepuestoDAOTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListar() {
        List<Repuesto> listaMock = new ArrayList<>();
        Repuesto repuestoMock = new Repuesto();
        repuestoMock.setIdrepuesto(1);
        repuestoMock.setFkidalmacen(1);
        repuestoMock.setFkidestado(1);
        repuestoMock.setNombre("Repuesto 1");
        repuestoMock.setFkidcategoria(1);
        repuestoMock.setImagen("imagen.jpg");
        repuestoMock.setPreciounitario(10.0);
        repuestoMock.setCantidad(10);
        listaMock.add(repuestoMock);
        when(repuestoDAO.listar()).thenReturn(listaMock);

        List<Repuesto> resultado = repuestoDAO.listar();

        verify(repuestoDAO, times(1)).listar();
        assertEquals(listaMock, resultado);
    }

    @Test
    public void testList() {
        int idRepuesto = 1;
        Repuesto repuestoMock = new Repuesto();
        repuestoMock.setIdrepuesto(idRepuesto);
        repuestoMock.setFkidalmacen(1);
        repuestoMock.setFkidestado(1);
        repuestoMock.setNombre("Repuesto 1");
        repuestoMock.setFkidcategoria(1);
        repuestoMock.setImagen("imagen.jpg");
        repuestoMock.setPreciounitario(10.0);
        repuestoMock.setCantidad(10);
        when(repuestoDAO.list(idRepuesto)).thenReturn(repuestoMock);

        Repuesto resultado = repuestoDAO.list(idRepuesto);

        verify(repuestoDAO, times(1)).list(idRepuesto);
        assertEquals(repuestoMock, resultado);
    }

    @Test
    public void testAdd() {
        Repuesto repuestoMock = new Repuesto();
        repuestoMock.setIdrepuesto(1);
        repuestoMock.setFkidalmacen(1);
        repuestoMock.setFkidestado(1);
        repuestoMock.setNombre("Repuesto 1");
        repuestoMock.setFkidcategoria(1);
        repuestoMock.setImagen("imagen.jpg");
        repuestoMock.setPreciounitario(10.0);
        repuestoMock.setCantidad(10);
        when(repuestoDAO.add(repuestoMock)).thenReturn(true);

        boolean resultado = repuestoDAO.add(repuestoMock);

        verify(repuestoDAO, times(1)).add(repuestoMock);
        assertTrue(resultado);
    }

    @Test
    public void testEdit() {
        Repuesto repuestoMock = new Repuesto();
        repuestoMock.setIdrepuesto(1);
        repuestoMock.setFkidalmacen(1);
        repuestoMock.setFkidestado(1);
        repuestoMock.setNombre("Repuesto 1");
        repuestoMock.setFkidcategoria(1);
        repuestoMock.setImagen("imagen.jpg");
        repuestoMock.setPreciounitario(10.0);
        repuestoMock.setCantidad(10);
        when(repuestoDAO.edit(repuestoMock)).thenReturn(true);

        boolean resultado = repuestoDAO.edit(repuestoMock);

        verify(repuestoDAO, times(1)).edit(repuestoMock);
        assertTrue(resultado);
    }

    
}
