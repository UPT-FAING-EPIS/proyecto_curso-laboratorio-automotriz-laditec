/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModeloDAO;

import Modelo.Repuesto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class RepuestoDAOTest {

    public RepuestoDAOTest() {
    }

    @Test
    public void testListar_ReturnsListOfRepuestos() {
        // Prueba del método listar
        RepuestoDAO repuestoDAO = new RepuestoDAO();

        // Agregar lógica para insertar algunos datos de prueba en la base de datos
        List<Repuesto> result = repuestoDAO.listar();

        assertFalse(result.isEmpty());
        // Agregar más aserciones según los resultados esperados de la consulta
    }

    @Test
    public void testList_ValidId_ReturnsRepuestoObject() {
        // Prueba del método list con un ID válido
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        int id = 1;

        Repuesto result = repuestoDAO.list(id);

        assertNotNull(result);
        assertEquals(id, result.getIdrepuesto());
    }

    @Test
    public void testAdd_ValidRepuesto_ReturnsTrue() {
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        Repuesto rep = new Repuesto();
        rep.setIdrepuesto(51);
        rep.setFkidalmacen(2);
        rep.setFkidestado(2);
        rep.setNombre("asd");
        rep.setFkidcategoria(1);
        rep.setImagen("png");
        rep.setPreciounitario(150.5);
        rep.setCantidad(5);

        boolean result = repuestoDAO.add(rep);
        assertTrue(result);

        
        
    }

    @Test
    public void testEdit_ValidRepuesto_ReturnsTrue() {

        RepuestoDAO repuestoDAO = new RepuestoDAO();
        Repuesto rep = new Repuesto();
        rep.setIdrepuesto(1);
        rep.setFkidalmacen(1);
        rep.setFkidestado(1);
        rep.setNombre("Juego de 4 piezas de inyectores - Nissan - Prueba");
        rep.setFkidcategoria(1);
        rep.setImagen("png");
        rep.setPreciounitario(180.5);
        rep.setCantidad(10);

        boolean result = repuestoDAO.edit(rep);

        assertTrue(result);
    }

}
