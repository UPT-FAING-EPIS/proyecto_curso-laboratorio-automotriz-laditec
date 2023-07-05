
package ModeloDAO;

import Modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


/**
 * Pruebas unitarias para LoginDAO
 */

public class LoginDAOTest {
    
    @Mock
    private LoginDAO loginDAO;

    public LoginDAOTest() {
    }

    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testLoginUsuario() {
        Usuario usuarioMock = new Usuario();
        usuarioMock.setIdusuario(1);
        usuarioMock.setNomusuario("John Doe");
        usuarioMock.setEmail("john@example.com");
        usuarioMock.setClave("password");
        usuarioMock.setFkidrol(2);
        usuarioMock.setEstado("activo");
        usuarioMock.setIntentos(0);
        when(loginDAO.loginUsuario(anyString(), anyString())).thenReturn(usuarioMock);

        Usuario resultado = loginDAO.loginUsuario("john@example.com", "password");

        verify(loginDAO, times(1)).loginUsuario("john@example.com", "password");
        assertEquals(usuarioMock, resultado);
    }
    @Test
    public void testLoginUsuario_ValidCredentials_ReturnsUser() {
        Usuario usuarioMock = new Usuario();
        usuarioMock.setIdusuario(1);
        usuarioMock.setNomusuario("John Doe");
        usuarioMock.setEmail("john@example.com");
        usuarioMock.setClave("password");
        usuarioMock.setFkidrol(2);
        usuarioMock.setEstado("activo");
        usuarioMock.setIntentos(0);
        when(loginDAO.loginUsuario(anyString(), anyString())).thenReturn(usuarioMock);

        Usuario resultado = loginDAO.loginUsuario("john@example.com", "password");

        verify(loginDAO, times(1)).loginUsuario("john@example.com", "password");
        assertEquals(usuarioMock, resultado);
    }

    @Test
    public void testLoginUsuario_InvalidCredentials_ReturnsNull() {
        when(loginDAO.loginUsuario(anyString(), anyString())).thenReturn(null);

        Usuario resultado = loginDAO.loginUsuario("john@example.com", "wrong_password");

        verify(loginDAO, times(1)).loginUsuario("john@example.com", "wrong_password");
        assertNull(resultado);
    }


}
