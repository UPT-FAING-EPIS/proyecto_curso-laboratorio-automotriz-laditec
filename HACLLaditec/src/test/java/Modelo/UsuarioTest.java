/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andre
 */
public class UsuarioTest {
    
    public UsuarioTest() {
    }
    
    @Test
    public void testGetSetIdUsuario() {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(1);
        assertEquals(1, usuario.getIdusuario());
    }

    @Test
    public void testGetSetNomUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomusuario("diego");
        assertEquals("diego", usuario.getNomusuario());
    }

    @Test
    public void testGetSetEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("diego@example.com");
        assertEquals("diego@example.com", usuario.getEmail());
    }

    @Test
    public void testGetSetClave() {
        Usuario usuario = new Usuario();
        usuario.setClave("password");
        assertEquals("password", usuario.getClave());
    }

    @Test
    public void testGetSetFkidRol() {
        Usuario usuario = new Usuario();
        usuario.setFkidrol(2);
        assertEquals(2, usuario.getFkidrol());
    }

    @Test
    public void testGetSetEstado() {
        Usuario usuario = new Usuario();
        usuario.setEstado("activo");
        assertEquals("activo", usuario.getEstado());
    }

    @Test
    public void testGetSetIntentos() {
        Usuario usuario = new Usuario();
        usuario.setIntentos(3);
        assertEquals(3, usuario.getIntentos());
    }
    
}
