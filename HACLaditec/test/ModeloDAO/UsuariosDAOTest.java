/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModeloDAO;

import Modelo.Usuario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class UsuariosDAOTest {
    
    public UsuariosDAOTest() {
    }
    
    /**
     * Test of listar method, of class UsuariosDAO.
     */
    @Test
    public void testListar() {
        UsuariosDAO instance = new UsuariosDAO();
        List<Usuario> result = instance.listar();
        assertNotNull(result);

    }

    
    @Test
    public void testList() {
        int id = 1;
        UsuariosDAO instance = new UsuariosDAO();
        Usuario result = instance.list(id);
        assertNotNull(result);
    }

    @Test
    public void testUpdateintentos() {
        String email = "test@example.com";
        UsuariosDAO instance = new UsuariosDAO();
        boolean result = instance.Updateintentos(email);
        assertTrue(result);
    }

    @Test
    public void testSacarintentos() {
        String email = "test@example.com";
        UsuariosDAO instance = new UsuariosDAO();
        int result = instance.sacarintentos(email);
        assertTrue(result >= 0);
    }

 
    @Test
    public void testDesactivarCuenta() {
        String email = "nuevointento@gmail.com";
        UsuariosDAO instance = new UsuariosDAO();
        boolean result = instance.DesactivarCuenta(email);
        assertTrue(result);

    }

    @Test
    public void testUpdatebloqueos() {
        String email = "nuevointento@gmail.com";
        UsuariosDAO instance = new UsuariosDAO();
        boolean result = instance.Updatebloqueos(email);
        assertTrue(result);
    }

    @Test
    public void testAdd() {
        Usuario usu = new Usuario();
        usu.setNomusuario("John Doe");
        usu.setEmail("john@example.com");
        usu.setClave("password");
        usu.setFkidrol(1);
        usu.setEstado("A");
        
        UsuariosDAO instance = new UsuariosDAO();
        boolean result = instance.add(usu);
        assertTrue(result);
    }

    @Test
    public void testEdit() {
        Usuario usu = new Usuario();
        usu.setIdusuario(1);
        usu.setNomusuario("John Doe");
        usu.setEmail("john@example.com");
        usu.setClave("newpassword");
        usu.setFkidrol(2);
        usu.setEstado("A");
        
        UsuariosDAO instance = new UsuariosDAO();
        boolean result = instance.edit(usu);
        assertTrue(result);
    }
    
    
}
