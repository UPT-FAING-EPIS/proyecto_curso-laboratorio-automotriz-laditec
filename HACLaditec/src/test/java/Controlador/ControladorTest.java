/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controlador;

import javax.servlet.RequestDispatcher;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

/**
 * @author JUNIOR-PC
 */
public class ControladorTest {

    public ControladorTest() {
    }

    @Test
    public void testDoGet_ListarPedido() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("ListarPedido");
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_AgregarPedido() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("AgregarPedido");
        Mockito.when(request.getParameter("AgregarPedidoDB")).thenReturn("1");
        Mockito.when(request.getParameter("txtUsuario")).thenReturn("1");
        Mockito.when(request.getParameter("txtFecha")).thenReturn("2023-05-14");
        Mockito.when(request.getParameter("txtEstado")).thenReturn("A");
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_VerPedidosBoleta() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("VerPedidosBoleta");
        
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_VerPedidosBoleta2() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("VerPedidosBoleta2");
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_EditarPedido() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("EditarPedido");
        Mockito.when(request.getParameter("EditarPedidoDB")).thenReturn("1");
        
        Mockito.when(request.getParameter("txtid")).thenReturn("36");
        Mockito.when(request.getParameter("txtPedido")).thenReturn("36");
        Mockito.when(request.getParameter("txtUsuario")).thenReturn("5");
        Mockito.when(request.getParameter("txtFecha")).thenReturn("2022-11-26");
        Mockito.when(request.getParameter("txtEstado")).thenReturn("A");
        Mockito.when(request.getParameter("txtTxrid")).thenReturn("c310e623afed134e5a288add747b41fd351be5f5");

        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_Logear() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("LogearUsuario");
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_Logout() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("LogoutUsuario");
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_RegistrarUsuario() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("RegistrarUsuario");

        Mockito.when(request.getParameter("RegistrarUsuarioDB")).thenReturn("36");
        Mockito.when(request.getParameter("txtnomusuario")).thenReturn("ads");
        Mockito.when(request.getParameter("txtemail")).thenReturn("asd");
        Mockito.when(request.getParameter("txtclave")).thenReturn("2022");

        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_AgregarUsuarios() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("AgregarUsuarios");
        Mockito.when(request.getParameter("AgregarUsuariosDB")).thenReturn("36");

        Mockito.when(request.getParameter("txtnomusuario")).thenReturn("James");
        Mockito.when(request.getParameter("txtemail")).thenReturn("holamundo");
        Mockito.when(request.getParameter("txtclave")).thenReturn("2022");
        Mockito.when(request.getParameter("txtfkidrol")).thenReturn("1");
        Mockito.when(request.getParameter("txtestado")).thenReturn("A");

        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_EditarUsuarios() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);

        Mockito.when(request.getParameter("accion")).thenReturn("EditarUsuarios");
        Mockito.when(request.getParameter("EditarUsuariosDB")).thenReturn("36");
        
        Mockito.when(request.getParameter("txtuser")).thenReturn("1");
        
        Mockito.when(request.getParameter("txtidusuario")).thenReturn("1");
        Mockito.when(request.getParameter("txtnomusuario")).thenReturn("James");
        Mockito.when(request.getParameter("txtemail")).thenReturn("holamundo");
        Mockito.when(request.getParameter("txtclave")).thenReturn("2022");
        Mockito.when(request.getParameter("txtfkidrol")).thenReturn("1");
        Mockito.when(request.getParameter("txtestado")).thenReturn("A");

        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_AgregarRepuesto() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);

        Mockito.when(request.getParameter("accion")).thenReturn("AgregarRepuesto");
        Mockito.when(request.getParameter("AgregarRepuestoDB")).thenReturn("36");
        Mockito.when(request.getParameter("txtRepuesto")).thenReturn("1");
        Mockito.when(request.getParameter("txtFkidalmacen")).thenReturn("2");
        Mockito.when(request.getParameter("txtFkidestado")).thenReturn("3");
        Mockito.when(request.getParameter("txtNombre")).thenReturn("nombreRepuesto");
        Mockito.when(request.getParameter("txtFkidcategoria")).thenReturn("4");
        Mockito.when(request.getParameter("txtImagen")).thenReturn("imagenRepuesto");
        Mockito.when(request.getParameter("txtPrecioUnitario")).thenReturn("10.5");
        Mockito.when(request.getParameter("txtcantidad")).thenReturn("5");

        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    @Test
    public void testDoGet_EditarRepuesto() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);
        
        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("EditarRepuesto");
        Mockito.when(request.getParameter("EditarRepuestoDB")).thenReturn("36");

        Mockito.when(request.getParameter("txtid")).thenReturn("1");
        Mockito.when(request.getParameter("txtRepuesto")).thenReturn("2");
        Mockito.when(request.getParameter("txtFkidalmacen")).thenReturn("3");
        Mockito.when(request.getParameter("txtFkidestado")).thenReturn("4");
        Mockito.when(request.getParameter("txtNombre")).thenReturn("NombreRepuesto");
        Mockito.when(request.getParameter("txtFkidcategoria")).thenReturn("5");
        Mockito.when(request.getParameter("txtImagen")).thenReturn("imagen.jpg");
        Mockito.when(request.getParameter("txtPrecioUnitario")).thenReturn("10.5");
        Mockito.when(request.getParameter("txtCantidad")).thenReturn("20");

        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doGet(request, response);
    }

    
    @Test
    public void testDoPost_Login() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("LogearUsuario");
        Mockito.when(request.getParameter("LogearUsuarioForm")).thenReturn("true");
        Mockito.when(request.getParameter("txtEmail")).thenReturn("jorge123@gmail.com");
        Mockito.when(request.getParameter("txtPassword")).thenReturn("jorge123");
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doPost(request, response);
    }
    
      
    @Test
    public void testDoPost_Register() throws Exception {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        HttpSession session = Mockito.mock(HttpSession.class);
        RequestDispatcher requestDispatcher = Mockito.mock(RequestDispatcher.class);

        Mockito.when(request.getSession(true)).thenReturn(session);
        Mockito.when(request.getParameter("accion")).thenReturn("RegistrarUsuario");
        Mockito.when(request.getParameter("RegistrarUsuarioDB")).thenReturn("true");
        
        Mockito.when(request.getParameter("txtnomusuario")).thenReturn("diego");
        Mockito.when(request.getParameter("txtemail")).thenReturn("diego@gmail.com");
        Mockito.when(request.getParameter("txtclave")).thenReturn("diego123");
        
        
        Mockito.when(request.getRequestDispatcher(Mockito.anyString())).thenReturn(requestDispatcher);

        Controlador controlador = new Controlador();
        controlador.doPost(request, response);
    }
    

}
