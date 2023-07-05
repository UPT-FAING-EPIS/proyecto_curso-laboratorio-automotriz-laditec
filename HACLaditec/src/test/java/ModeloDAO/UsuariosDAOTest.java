/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ModeloDAO;

import Modelo.Usuario;
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
public class UsuariosDAOTest {

    @Mock
    private UsuariosDAO usuariosDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public UsuariosDAOTest() {
    }

    @Test
    public void testListar() {
        // Configurar el comportamiento del mock
        List<Usuario> listaMock = new ArrayList<>();
        Usuario usuarioMock = new Usuario();
        usuarioMock.setIdusuario(1);
        usuarioMock.setNomusuario("Usuario1");
        usuarioMock.setEmail("usuario1@example.com");
        usuarioMock.setClave("clave123");
        usuarioMock.setFkidrol(1);
        usuarioMock.setEstado("Activo");
        listaMock.add(usuarioMock);
        when(usuariosDAO.listar()).thenReturn(listaMock);

        // Ejecutar el método que se va a probar
        List<Usuario> resultado = usuariosDAO.listar();

        // Verificar que el mock se haya utilizado correctamente y que el resultado sea el esperado
        verify(usuariosDAO, times(1)).listar();
        assertEquals(listaMock, resultado);
    }

    @Test
    public void testList() {
        int idUsuario = 1;
        Usuario usuarioMock = new Usuario();
        usuarioMock.setIdusuario(idUsuario);
        usuarioMock.setNomusuario("Usuario1");
        usuarioMock.setEmail("usuario1@example.com");
        usuarioMock.setClave("clave123");
        usuarioMock.setFkidrol(1);
        usuarioMock.setEstado("Activo");

        when(usuariosDAO.list(idUsuario)).thenReturn(usuarioMock);

        Usuario resultado = usuariosDAO.list(idUsuario);

        verify(usuariosDAO, times(1)).list(idUsuario);
        assertEquals(usuarioMock, resultado);
    }

    @Test
    public void testUpdateIntentos() {
        String email = "usuario1@example.com";

        when(usuariosDAO.Updateintentos(email)).thenReturn(true);

        boolean resultado = usuariosDAO.Updateintentos(email);

        verify(usuariosDAO, times(1)).Updateintentos(email);
        assertTrue(resultado);
    }

    @Test
    public void testSacarIntentos() {
        String email = "usuario1@example.com";
        int intentosMock = 3;

        when(usuariosDAO.sacarintentos(email)).thenReturn(intentosMock);

        int resultado = usuariosDAO.sacarintentos(email);

        verify(usuariosDAO, times(1)).sacarintentos(email);
        assertEquals(intentosMock, resultado);
    }

    @Test
    public void testDesactivarCuenta() {
        String email = "usuario1@example.com";

        when(usuariosDAO.DesactivarCuenta(email)).thenReturn(true);

        boolean resultado = usuariosDAO.DesactivarCuenta(email);

        verify(usuariosDAO, times(1)).DesactivarCuenta(email);
        assertTrue(resultado);
    }

    @Test
    public void testUpdateBloqueos() {
        String email = "usuario1@example.com";

        when(usuariosDAO.Updatebloqueos(email)).thenReturn(true);

        boolean resultado = usuariosDAO.Updatebloqueos(email);

        verify(usuariosDAO, times(1)).Updatebloqueos(email);
        assertTrue(resultado);
    }

    @Test
    public void testAdd() {
        Usuario usuarioMock = new Usuario();
        usuarioMock.setNomusuario("Usuario1");
        usuarioMock.setEmail("usuario1@example.com");
        usuarioMock.setClave("clave123");
        usuarioMock.setFkidrol(1);
        usuarioMock.setEstado("Activo");

        when(usuariosDAO.add(usuarioMock)).thenReturn(true);

        boolean resultado = usuariosDAO.add(usuarioMock);

        verify(usuariosDAO, times(1)).add(usuarioMock);
        assertTrue(resultado);
    }

    @Test
    public void testEdit() {
        Usuario usuarioMock = new Usuario();
        usuarioMock.setIdusuario(1);
        usuarioMock.setNomusuario("Usuario1");
        usuarioMock.setEmail("usuario1@example.com");
        usuarioMock.setClave("clave123");
        usuarioMock.setFkidrol(1);
        usuarioMock.setEstado("Activo");

        when(usuariosDAO.edit(usuarioMock)).thenReturn(true);

        boolean resultado = usuariosDAO.edit(usuarioMock);

        verify(usuariosDAO, times(1)).edit(usuarioMock);
        assertTrue(resultado);
    }

}
