/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Interfaces.crudPedidoVenta;
import Interfaces.crudRepuesto;
import Interfaces.crudUsuarios;
import Modelo.*;
import ModeloDAO.*;

/*
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author HACL
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
   
        PedidoVenta ped = new PedidoVenta();
        crudPedidoVenta dao = new PedidoVentaDAO();
        Repuesto rep = new Repuesto();
        crudRepuesto daorep = new RepuestoDAO();
        Usuario usu = new Usuario();
        crudUsuarios udao = new UsuariosDAO();


        String acceso = "";
        String action = request.getParameter("accion");

        switch (action) {
            case "AgregarPedido":
                acceso = "VistaPedido/agregarPedido.jsp";
                if (request.getParameter("AgregarPedidoDB") != null) {
                    try {

                        ped.setIdusuario(Integer.parseInt(request.getParameter("txtUsuario")));
                        ped.setFecha(request.getParameter("txtFecha"));
                        ped.setEstado(request.getParameter("txtEstado"));
                        if (dao.add(ped) == true) {
                            System.out.println("se ha Agregado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }

                        acceso = "VistaPedido/index.jsp";

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                }
                break;
            case "ListarPedido":
                acceso = "VistaPedido/index.jsp";
                break;
            case "VerPedidosBoleta":
                acceso = "VerMisPedidos.jsp";
                break;
            case "VerPedidosBoleta2":
                acceso = "VistaBoletaVenta/index.jsp";
                break;
            case "EditarPedido":

                acceso = "VistaPedido/editarPedido.jsp";
                request.setAttribute("idped", request.getParameter("txtid"));
                if (request.getParameter("EditarPedidoDB") != null) {
                    try {
                        ped.setIdpedido(Integer.parseInt(request.getParameter("txtPedido")));
                        ped.setIdusuario(Integer.parseInt(request.getParameter("txtUsuario")));
                        ped.setFecha(request.getParameter("txtFecha"));
                        ped.setEstado(request.getParameter("txtEstado"));
                        ped.setTxrid(request.getParameter("txtTxrid"));

                        if (dao.edit(ped) == true) {
                            System.out.println("se ha Editado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }

                        acceso = "VistaPedido/index.jsp";

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }

                }
                break;
            case "LogearUsuario":
                acceso = "Login.jsp";
                break;
            case "LogoutUsuario":
                acceso = "index.jsp";
                sesion.invalidate();
                break;
            case "RegistrarUsuario":

                acceso = "Register.jsp";
                if (request.getParameter("RegistrarUsuarioDB") != null) {
                    try {

                        usu.setNomusuario(request.getParameter("txtnomusuario"));
                        usu.setEmail(request.getParameter("txtemail"));
                        usu.setClave(request.getParameter("txtclave"));
                        usu.setFkidrol(1);
                        usu.setEstado("A");

                        if (udao.add(usu) == true) {
                            System.out.println("se ha Agregado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }

                        acceso = "Login.jsp";

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;

            case "listarUsuarios":
                acceso = "VistaUsuarios/index.jsp";
                break;
            case "AgregarUsuarios":

                acceso = "VistaUsuarios/agregarUsuarios.jsp";
                if (request.getParameter("AgregarUsuariosDB") != null) {
                    try {

                        usu.setNomusuario(request.getParameter("txtnomusuario"));
                        usu.setEmail(request.getParameter("txtemail"));
                        usu.setClave(request.getParameter("txtclave"));
                        usu.setFkidrol(Integer.parseInt(request.getParameter("txtfkidrol")));
                        usu.setEstado(request.getParameter("txtestado"));
                        if (udao.add(usu) == true) {
                            System.out.println("se ha Agregado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }

                        acceso = "VistaUsuarios/index.jsp";

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }

                }
                break;
            case "EditarUsuarios":

                acceso = "VistaUsuarios/editarUsuarios.jsp";
                request.setAttribute("user", request.getParameter("txtuser"));
                if (request.getParameter("EditarUsuariosDB") != null) {
                    try {
                        usu.setIdusuario(Integer.parseInt(request.getParameter("txtidusuario")));
                        usu.setNomusuario(request.getParameter("txtnomusuario"));
                        usu.setEmail(request.getParameter("txtemail"));
                        usu.setClave(request.getParameter("txtclave"));
                        usu.setFkidrol(Integer.parseInt(request.getParameter("txtfkidrol")));
                        usu.setEstado(request.getParameter("txtestado"));

                        if (udao.edit(usu) == true) {
                            System.out.println("se ha Editado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }

                        acceso = "VistaUsuarios/index.jsp";

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }

                }
                break;
            case "ListarRepuestos":
                acceso = "VistaRepuesto/index.jsp";
                break;
            case "AgregarRepuesto":
                acceso = "VistaRepuesto/agregarRepuesto.jsp";
                if (request.getParameter("AgregarRepuestoDB") != null) {
                    try {
                        rep.setIdrepuesto(Integer.parseInt(request.getParameter("txtRepuesto")));
                        rep.setFkidalmacen(Integer.parseInt(request.getParameter("txtFkidalmacen")));
                        rep.setFkidestado(Integer.parseInt(request.getParameter("txtFkidestado")));
                        rep.setNombre(request.getParameter("txtNombre"));
                        rep.setFkidcategoria(Integer.parseInt(request.getParameter("txtFkidcategoria")));
                        rep.setImagen(request.getParameter("txtImagen"));
                        rep.setPreciounitario(Double.parseDouble(request.getParameter("txtPrecioUnitario")));
                        rep.setCantidad(Integer.parseInt(request.getParameter("txtcantidad")));

                        if (daorep.add(rep) == true) {
                            System.out.println("se ha Agregado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }
                        acceso = "VistaRepuesto/index.jsp";

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                }
                break;
            case "EditarRepuesto":

                acceso = "VistaRepuesto/editarRepuesto.jsp";

                request.setAttribute("id", request.getParameter("txtid"));
                if (request.getParameter("EditarRepuestoDB") != null) {
                    try {
                        rep.setIdrepuesto(Integer.parseInt(request.getParameter("txtRepuesto")));
                        rep.setFkidalmacen(Integer.parseInt(request.getParameter("txtFkidalmacen")));
                        rep.setFkidestado(Integer.parseInt(request.getParameter("txtFkidestado")));
                        rep.setNombre(request.getParameter("txtNombre"));
                        rep.setFkidcategoria(Integer.parseInt(request.getParameter("txtFkidcategoria")));
                        rep.setImagen(request.getParameter("txtImagen"));
                        rep.setPreciounitario(Double.parseDouble(request.getParameter("txtPrecioUnitario")));
                        rep.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));

                        if (daorep.edit(rep) == true) {
                            System.out.println("se ha Editado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }

                        acceso = "VistaRepuesto/index.jsp";

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }

                }
                break;

        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);
        Usuario usu = new Usuario();
        UsuariosDAO udao = new UsuariosDAO();
        String acceso = "";
        String action = request.getParameter("accion");

        switch (action) {

            case "LogearUsuario":
                acceso = "Login.jsp";
                if (request.getParameter("LogearUsuarioForm") != null) {
                    try {
                        LoginDAO logindao = new LoginDAO();
                        UsuariosDAO userdao = new UsuariosDAO();

                        String user = request.getParameter("txtEmail");
                        String clave = request.getParameter("txtPassword");

                        usu = logindao.loginUsuario(user, clave);
                        if (usu != null) {

                            if (usu.getEstado().equalsIgnoreCase("A")) {

                                acceso = "cruds.jsp";
                                sesion.setAttribute("fkidrolusuario", usu.getFkidrol());
                                sesion.setAttribute("idusuario", usu.getIdusuario());
                                sesion.setAttribute("nomusuariologin", usu.getNomusuario());

                            }

                        } else {
                            userdao.Updateintentos(user);
                            int intentos = userdao.sacarintentos(user);

                            if (intentos == 3) {
                                userdao.Updatebloqueos(user);
                                userdao.DesactivarCuenta(user);
                            }

                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;

            case "RegistrarUsuario":

                acceso = "Register.jsp";
                if (request.getParameter("RegistrarUsuarioDB") != null) {
                    try {

                        usu.setNomusuario(request.getParameter("txtnomusuario"));
                        usu.setEmail(request.getParameter("txtemail"));
                        usu.setClave(request.getParameter("txtclave"));
                        usu.setFkidrol(1);
                        usu.setEstado("A");

                        if (udao.add(usu) == true) {
                            System.out.println("se ha Agregado correctamente");
                        } else {
                            System.out.println("error de base de datos");
                        }

                        acceso = "Login.jsp";

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                break;

        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
