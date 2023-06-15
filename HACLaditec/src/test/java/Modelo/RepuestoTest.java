/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class RepuestoTest {
    
    public RepuestoTest() {
    }
    
    @Test
    public void testGetSetIdRepuesto() {
        Repuesto repuesto = new Repuesto();
        repuesto.setIdrepuesto(1);
        assertEquals(1, repuesto.getIdrepuesto());
    }

    @Test
    public void testGetSetFkidAlmacen() {
        Repuesto repuesto = new Repuesto();
        repuesto.setFkidalmacen(2);
        assertEquals(2, repuesto.getFkidalmacen());
    }

    @Test
    public void testGetSetFkidEstado() {
        Repuesto repuesto = new Repuesto();
        repuesto.setFkidestado(3);
        assertEquals(3, repuesto.getFkidestado());
    }

    @Test
    public void testGetSetNombre() {
        Repuesto repuesto = new Repuesto();
        repuesto.setNombre("Llanta");
        assertEquals("Llanta", repuesto.getNombre());
    }

    @Test
    public void testGetSetFkidCategoria() {
        Repuesto repuesto = new Repuesto();
        repuesto.setFkidcategoria(4);
        assertEquals(4, repuesto.getFkidcategoria());
    }

    @Test
    public void testGetSetImagen() {
        Repuesto repuesto = new Repuesto();
        repuesto.setImagen("llanta.jpg");
        assertEquals("llanta.jpg", repuesto.getImagen());
    }

    @Test
    public void testGetSetPrecioUnitario() {
        Repuesto repuesto = new Repuesto();
        repuesto.setPreciounitario(99.99);
        assertEquals(99.99, repuesto.getPreciounitario(), 0.01);
    }

    @Test
    public void testGetSetCantidad() {
        Repuesto repuesto = new Repuesto();
        repuesto.setCantidad(5);
        assertEquals(5, repuesto.getCantidad());
    }
    
}
