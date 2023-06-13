/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModeloDAO;

import Modelo.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class LoginDAOTest {
    
    public LoginDAOTest() {
    }
    
    
    @Test
    public void testLoginUsuario_ValidCredentials_ReturnsUsuarioObject() {
        // Prueba de credenciales válidas
        LoginDAO loginDAO = new LoginDAO();
        String user = "nuevointento@gmail.com";
        String clave = "nuevointento";

        Usuario result = loginDAO.loginUsuario(user, clave);

        assertNotNull(result);
        assertEquals(user, result.getEmail());
        assertEquals(clave, result.getClave());
    }

    @Test
    public void testLoginUsuario_InvalidCredentials_ReturnsNull() {
        // Prueba de credenciales inválidas
        LoginDAO loginDAO = new LoginDAO();
        String user = "nonexistent@example.com";
        String clave = "invalidpassword";

        Usuario result = loginDAO.loginUsuario(user, clave);

        assertNull(result);
    }

    @Test
    public void testLoginUsuario_EmptyUserAndEmptyClave_ReturnsNull() {
        // Prueba de usuario y clave vacíos
        LoginDAO loginDAO = new LoginDAO();
        String user = "";
        String clave = "";

        Usuario result = loginDAO.loginUsuario(user, clave);

        assertNull(result);
    }

    @Test
    public void testLoginUsuario_NullUserAndNullClave_ReturnsNull() {
        // Prueba de usuario y clave nulos
        LoginDAO loginDAO = new LoginDAO();
        String user = null;
        String clave = null;

        Usuario result = loginDAO.loginUsuario(user, clave);

        assertNull(result);
    }
    
    
}
